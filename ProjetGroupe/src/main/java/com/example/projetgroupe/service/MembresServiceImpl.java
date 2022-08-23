package com.example.projetgroupe.service;

import com.example.projetgroupe.bo.Articles;
import com.example.projetgroupe.bo.Membres;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembresServiceImpl implements MembresService {

    private List<Membres> membresListe = new ArrayList<>();
    private int compteur = 0;

    @Override
    public void addMembres(Membres membres) {
        compteur++;
        membres.setPseudo(String.valueOf(compteur));

        membresListe.add(membres);
    }

    @Override
    public List<Membres> listeMembres() {
        return membresListe;
    }

    @Override
    public Membres getMembresById(String pseudo) {
        for (Membres membres : membresListe) {
            if (membres.getPseudo() == pseudo) {
                return membres;
            }
        }
        // si pas trouvé
        return null;
    }

}
