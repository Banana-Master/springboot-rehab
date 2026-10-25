package com.example.springbootrehab.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springbootrehab.dto.ArticleForm;
import com.example.springbootrehab.entity.Article;
import com.example.springbootrehab.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ArticleController {
	@Autowired
	private ArticleRepository articleRepository;

	@GetMapping("/articles/new")
	public String newArticleForm() {
		return "articles/new";
	}

	@PostMapping("/articles/create")
	public String createArticle(ArticleForm form) {
		log.info(form.toString());
		// System.out.println(form.toString());
		Article article = form.toEntity();
		log.info(article.toString());
		// System.out.println(article.toString());
		Article saved = articleRepository.save(article);
		log.info(saved.toString());
		// System.out.println(saved.toString());
		return "";
	}

	@GetMapping("/articles/{id}")
	public String show(@PathVariable Long id, Model model) {
		log.info("id = " + id);
		Article articleEntity = articleRepository.findById(id).orElse(null);
		model.addAttribute("article", articleEntity);
		return "articles/show";
	}

	@GetMapping("/articles")
	public String index(Model model) {
		List<Article> articleEntityList = articleRepository.findAll();
		model.addAttribute("articleList", articleEntityList);
		return "articles/index";
	}
}
