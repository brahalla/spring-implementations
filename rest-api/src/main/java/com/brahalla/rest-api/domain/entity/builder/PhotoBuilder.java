package com.brahalla.restapi.domain.entity.builder;

import com.brahalla.restapi.domain.base.AbstractDomainBuilder;
import com.brahalla.restapi.domain.entity.Album;
import com.brahalla.restapi.domain.entity.Photo;

import java.util.Date;

public class PhotoBuilder implements AbstractDomainBuilder {

  private Long id;
  private String name;
  private Date createdDate;
  private Album album;

  public PhotoBuilder() {
    super();
  }

  public static PhotoBuilder create() {
    return new PhotoBuilder();
  }

  public PhotoBuilder withId(final Long id) {
    this.id = id;
    return this;
  }

  public Long getId() {
    return this.id;
  }

  public PhotoBuilder withName(final String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return this.name;
  }

  public PhotoBuilder withCreatedDate(final Date createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  public Date getCreatedDate() {
    return this.createdDate;
  }

  public PhotoBuilder withAlbum(final Album album) {
    this.album = album;
    return this;
  }

  public Album getAlbum() {
    return this.album;
  }

  @Override
  public Photo build() {
    return new Photo(this);
  }

}
