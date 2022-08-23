package com.example.projetgroupe.service;

import com.example.projetgroupe.bo.Membres;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembresServiceImpl implements MembresService {

    private List<Membres> membresListe = new ArrayList<>();

    @Override
    public void addMembres(Membres membres) {

        membresListe.add(membres);
    }

    @Override
    public List<Membres> listeMembres() {
        return membresListe;
    }

    @Override
    public Membres getMembresById(String pseudo) {
        for (Membres membres : membresListe) {
            if (membres.getPseudo().equals(pseudo)) {
                return membres;
            }
        }
        // si pas trouvé
        return null;
    }

}
