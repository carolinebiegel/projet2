package com.example.projetgroupe.service;

import com.example.projetgroupe.bo.Avis;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class AvisServiceImpl implements AvisService{


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


}
