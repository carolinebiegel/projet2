package com.example.projetgroupe.repository;

import com.example.projetgroupe.bo.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Articles, Long> {

    @Query("SELECT p FROM Articles p WHERE p.titre LIKE %?1%"
            + " OR p.description LIKE %?1%"
            + " OR p.categorie LIKE %?1%"
            )
    public List<Articles> search(String keyword);



    public List<Articles> findArticlesByMembresPseudo(String pseudo);

}
