package com.example.projetgroupe.repository;

import com.example.projetgroupe.bo.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Articles, Long> {
}
