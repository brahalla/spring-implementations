package com.brahalla.stompchat.controller;

import com.brahalla.stompchat.model.ChatMessage;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

  private List<String> users = new ArrayList<String>();

  @Autowired
  private SimpMessageSendingOperations messagingTemplate;

  @SubscribeMapping("/join")
  public List<String> handleJoinEvent(Principal principal) {
    if (!users.contains(principal.getName())) {
      users.add(principal.getName());
    }

    messagingTemplate.convertAndSend("/topic/join", principal.getName());    
    return users;
  }

  @MessageMapping("/chat")
  public void handleChatMessageEvent(ChatMessage chatMessage, Principal principal) {
    chatMessage.setFrom(principal.getName());

    if ("all".equals(chatMessage.getTo())) {
      messagingTemplate.convertAndSend("/queue/chats", chatMessage);
    } else {
      messagingTemplate.convertAndSendToUser(chatMessage.getTo(), "/queue/chats", chatMessage);
    }
  }

}
