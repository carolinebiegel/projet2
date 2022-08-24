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


    @Override
    public void addAvis(Avis avis) {

    }

    @Override
    public List<Avis> listeAvis() {
        return null;
    }

    @Override
    public List<Avis> findAvisByMembre(String pseudo) {
        return avisRepository.findAvisByMembresPseudo(pseudo);
    }


}
