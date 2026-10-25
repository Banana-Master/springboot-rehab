package com.example.springbootrehab.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springbootrehab.entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
