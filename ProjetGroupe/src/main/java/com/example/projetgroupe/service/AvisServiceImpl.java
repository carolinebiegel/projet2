package com.example.projetgroupe.service;

import com.example.projetgroupe.bo.Avis;
import com.example.projetgroupe.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class AvisServiceImpl implements AvisService{

    @Autowired
    private AvisRepository avisRepository;

    private List<Avis> listeAvis = new ArrayList<>();

    private int compteur = 0;

    @Override
    public void addAvis(Avis avis) {
        compteur++;
        avis.setId(compteur);
        listeAvis.add(avis);
    }

    @Override
    public List<Avis> listeAvis() {
        return listeAvis;
    }

    @Override
    public List<Avis> findAvisByMembre(String pseudo) {
        return avisRepository.findAvisByMembresPseudo(pseudo);
    }


}
