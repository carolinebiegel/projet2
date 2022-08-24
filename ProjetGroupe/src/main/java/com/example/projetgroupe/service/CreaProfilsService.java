package com.example.projetgroupe.service;

import com.example.projetgroupe.bo.Membres;

import java.util.List;

public interface CreaProfilsService {


    public void addMembres (Membres membres) throws Exception;

    public List<Membres> listeMembres();

    public Membres getMembresById(String pseudo);
}
