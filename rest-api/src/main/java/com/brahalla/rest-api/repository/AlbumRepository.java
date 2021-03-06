package com.brahalla.restapi.repository;

import com.brahalla.restapi.domain.entity.Album;
import com.brahalla.restapi.domain.entity.QAlbum;

import com.querydsl.core.types.dsl.StringPath;

import io.swagger.annotations.Api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@Api(tags = "Albums")
@RepositoryRestResource(collectionResourceRel = "albums", path = "albums")
public interface AlbumRepository extends PagingAndSortingRepository<Album, Long>, QuerydslPredicateExecutor<Album>, QuerydslBinderCustomizer<QAlbum> {

  @Override
  default void customize(QuerydslBindings bindings, QAlbum album) {
		bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));
	}

}
