package com.example.projetgroupe.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity @Getter  @Setter @NoArgsConstructor
public class Avis {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private int note;
    private String commentaire;

    @ManyToOne
    private Membres membres;

    @ManyToOne
    private Membres auteur;

}
