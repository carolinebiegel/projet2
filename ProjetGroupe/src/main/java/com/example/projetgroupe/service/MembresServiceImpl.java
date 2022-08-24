package com.example.projetgroupe.service;

import com.example.projetgroupe.bo.Membres;
import com.example.projetgroupe.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembresServiceImpl implements MembresService {

    @Autowired
    MembreRepository membresRepository;

    @Autowired
    PasswordEncoder passwordEncoder;



    @Override
    public void addMembres(Membres membres) throws Exception {

        String motDePasseEncode = passwordEncoder.encode(membres.getPassword());
        membres.setPassword(motDePasseEncode);

        membresRepository.save(membres);

    }

    @Override
    public List<Membres> listeMembres() {
        return membresRepository.findAll();
    }

    @Override
    public Membres getMembresById(String pseudo) {
        return membresRepository.findById(pseudo).get();

    }









}
