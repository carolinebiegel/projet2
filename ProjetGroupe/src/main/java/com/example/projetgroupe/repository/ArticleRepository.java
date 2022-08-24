package com.example.projetgroupe.repository;

import com.example.projetgroupe.bo.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Articles, Long> {

    public List<Articles> findArticlesByMembresPseudo(String pseudo);

}
