package com.example.projetgroupe.service;

import com.example.projetgroupe.bo.Articles;
import com.example.projetgroupe.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public void addArticle(Articles article) {
        articleRepository.save(article);

    }

    @Override
    public List<Articles> listeArticles() {


        return articleRepository.findAll();
    }

    @Override
    public Articles getArticleById(long id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public  List<Articles> findArticleByMembre(String pseudo) {
        return articleRepository.findArticlesByMembresPseudo(pseudo);
    }

    @Override
    public List<Articles> findArticleByKeyword(String keyword) {

        if (keyword != null) {
            return articleRepository.search(keyword);
        }
        return articleRepository.findAll();

    }




}
