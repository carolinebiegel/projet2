package com.example.projetgroupe.service;

import com.example.projetgroupe.bo.Articles;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private List<Articles> articlesListe = new ArrayList<>();
    private int compteur = 0;

    @Override
    public void addArticle(Articles articles) {
        compteur++;
        articles.setId(compteur);

        articlesListe.add(articles);
    }

    @Override
    public List<Articles> listeArticles() {
        return articlesListe;
    }

    @Override
    public Articles getArticleById(long id) {
        for (Articles articles : articlesListe) {
            if (articles.getId() == id) {
                return articles;
            }
        }
        // si pas trouvé
        return null;
    }
}
