package com.example.projetgroupe.service;

import com.example.projetgroupe.bo.Avis;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AvisService {


    public void addAvis(Avis avis);

    public List<Avis> listeAvis();



}