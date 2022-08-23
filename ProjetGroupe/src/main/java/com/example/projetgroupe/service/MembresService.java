package com.example.projetgroupe.service;

import com.example.projetgroupe.bo.Articles;
import com.example.projetgroupe.bo.Membres;

import java.util.List;

public interface MembresService {

    public void addMembres (Membres membres);

    public List<Membres> listeMembres();

    public Membres getMembresById(String pseudo);



}

