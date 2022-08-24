package com.example.projetgroupe.converter;

import com.example.projetgroupe.bo.Articles;
import com.example.projetgroupe.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class ArticleConverter implements Converter<String, Articles> {

    @Autowired
    private ArticleService articleService;

    @Override
    public Articles convert(String idAuFormatTexte) {
        long id = Integer.parseInt(idAuFormatTexte);
        return articleService.getArticleById(id);
    }
}
