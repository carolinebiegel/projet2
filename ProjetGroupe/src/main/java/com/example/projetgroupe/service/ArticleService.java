package com.example.projetgroupe.service;

import com.example.projetgroupe.bo.Articles;

import java.util.List;

public interface ArticleService {

    public void addArticle (Articles articles);

    public List<Articles> listeArticles();

    public Articles getArticleById(long id);

}

