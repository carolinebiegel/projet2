package com.example.projetgroupe.repository;

import com.example.projetgroupe.bo.Articles;
import com.example.projetgroupe.bo.Avis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvisRepository extends JpaRepository<Avis, Long> {

    public List<Avis> findAvisByMembresPseudo(String pseudo);

}
