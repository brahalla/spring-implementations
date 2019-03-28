package com.brahalla.multitenant.repository;

import com.brahalla.multitenant.domain.Photo;

import io.swagger.annotations.Api;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Api(tags = "Photos")
@RepositoryRestResource(collectionResourceRel = "photos", path = "photos")
public interface PhotoRepository extends PagingAndSortingRepository<Photo, Long> {}
