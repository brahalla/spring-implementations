package com.brahalla.restapi.repository;

import com.brahalla.restapi.domain.entity.Album;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "albums", path = "albums")
public interface AlbumRepository extends PagingAndSortingRepository<Album, Long> {

  @RestResource(path = "byName", rel = "byName")
  Page<Album> findByName(@Param("name") String name, Pageable p);

}
