package com.brahalla.restapi.repository;

import com.brahalla.restapi.domain.entity.Photo;
import com.brahalla.restapi.domain.entity.QPhoto;

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

@RepositoryRestResource(collectionResourceRel = "photos", path = "photos")
public interface PhotoRepository extends PagingAndSortingRepository<Photo, Long>, QueryDslPredicateExecutor<Photo>, QuerydslBinderCustomizer<QPhoto> {

  @Override
  default void customize(QuerydslBindings bindings, QPhoto photo) {
		bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));
	}

}
