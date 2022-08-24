package com.example.projetgroupe.service;

import com.example.projetgroupe.bo.Avis;
import com.example.projetgroupe.bo.Membres;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class AvisServiceImpl implements AvisService{


    private List<Avis> listeAvis = new ArrayList<>();

    @Override
    public List<Membres> listeMembres() {
        return AvisRepository.findAll();
    }

    @Override
    public Membres getMembresById(String pseudo) {
        return membresRepository.findById(pseudo).get();

    }


}
