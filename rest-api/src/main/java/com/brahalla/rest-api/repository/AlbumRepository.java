package com.brahalla.restapi.repository;

import com.brahalla.restapi.domain.entity.Album;
import com.brahalla.restapi.domain.entity.QAlbum;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.querydsl.core.types.dsl.StringPath;

@RepositoryRestResource(collectionResourceRel = "albums", path = "albums")
public interface AlbumRepository extends PagingAndSortingRepository<Album, Long>, QueryDslPredicateExecutor<Album>, QuerydslBinderCustomizer<QAlbum> {

  @Override
  default void customize(QuerydslBindings bindings, QAlbum album) {
		bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));
	}

}
