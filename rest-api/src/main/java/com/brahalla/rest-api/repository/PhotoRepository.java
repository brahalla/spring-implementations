package com.brahalla.restapi.repository;

import com.brahalla.restapi.domain.entity.Photo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "photos", path = "photos")
public interface PhotoRepository extends PagingAndSortingRepository<Photo, Long> {

  @RestResource(path = "byName", rel = "byName")
  Page<Photo> findByName(@Param("name") String name, Pageable p);

  @RestResource(path = "byAlbum", rel = "byAlbum")
  Page<Photo> findByAlbumId(@Param("id") Long albumId, Pageable p);

}
