package com.brahalla.restapi.domain.entity.builder;

import com.brahalla.restapi.domain.base.AbstractDomainBuilder;
import com.brahalla.restapi.domain.entity.Album;
import com.brahalla.restapi.domain.entity.Photo;

import java.util.Date;
import java.util.List;

public class AlbumBuilder implements AbstractDomainBuilder {

  private Long id;
  private String name;
  private Date createdDate;
  private List<Photo> photos;

  public AlbumBuilder() {
    super();
  }

  public static AlbumBuilder create() {
    return new AlbumBuilder();
  }

  public AlbumBuilder withId(final Long id) {
    this.id = id;
    return this;
  }

  public Long getId() {
    return this.id;
  }

  public AlbumBuilder withName(final String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return this.name;
  }

  public AlbumBuilder withCreatedDate(final Date createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  public Date getCreatedDate() {
    return this.createdDate;
  }

  public AlbumBuilder withPhotos(final List<Photo> photos) {
    this.photos = photos;
    return this;
  }

  public List<Photo> getPhotos() {
    return this.photos;
  }

  @Override
  public Album build() {
    return new Album(this);
  }

}
