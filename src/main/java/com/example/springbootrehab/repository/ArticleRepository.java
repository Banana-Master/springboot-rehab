package com.example.springbootrehab.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.springbootrehab.entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {
	@Override
	ArrayList<Article> findAll();
}
