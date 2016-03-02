package com.brahalla.stompchat.model;

import com.brahalla.stompchat.model.base.AbstractModel;

import java.util.Date;

public class ChatMessage extends AbstractModel {

  private String to;
  private String from;
  private Date timestamp;
  private String message;

  public ChatMessage() {
    super();
  }

  public String getTo() {
    return this.to;
  }

  public void setTo(final String to) {
    this.to = to;
  }

  public String getFrom() {
    return this.from;
  }

  public void setFrom(final String from) {
    this.from = from;
  }

  public Date getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(final Date timestamp) {
    this.timestamp = timestamp;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessate(final String message) {
    this.message = message;
  }

}
