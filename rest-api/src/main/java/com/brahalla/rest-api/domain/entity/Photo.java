package com.brahalla.restapi.domain.entity;

import com.brahalla.restapi.domain.base.AbstractDomain;
import com.brahalla.restapi.domain.entity.Album;
import com.brahalla.restapi.domain.entity.builder.PhotoBuilder;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "photos")
public class Photo extends AbstractDomain {

  private Long id;
  private String name;
  private Date createdDate;
  private Album album;

  public Photo() {
    super();
  }

  public Photo(final PhotoBuilder builder) {
    this.setId(builder.getId());
    this.setName(builder.getName());
    this.setCreatedDate(builder.getCreatedDate());
    this.setAlbum(builder.getAlbum());
  }

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "photos_seq")
  @SequenceGenerator(name = "photos_seq", sequenceName = "photos_seq", allocationSize = 1)
  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  @Column(name = "name")
  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Column(name = "created_date")
  @Temporal(TemporalType.TIMESTAMP)
  public Date getCreatedDate() {
    return this.createdDate;
  }

  public void setCreatedDate(final Date createdDate) {
    this.createdDate = createdDate;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "album_id")
  public Album getAlbum() {
    return this.album;
  }

  public void setAlbum(final Album album) {
    this.album = album;
  }

}
