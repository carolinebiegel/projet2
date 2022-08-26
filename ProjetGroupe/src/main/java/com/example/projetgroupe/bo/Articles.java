package com.example.projetgroupe.bo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Setter @Getter @Entity
public class Articles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate datePublication = LocalDate.now();
    private String titre;
    private Genres genre;
    private String categorie;
    private String description;
    private String etat;
    private long prix;

    @ManyToOne
    private Membres membres;

  // ajout d'une photo

    @Column(nullable = true, length = 150)
    private String photos;


}
