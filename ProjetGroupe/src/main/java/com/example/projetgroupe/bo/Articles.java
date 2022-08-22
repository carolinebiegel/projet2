package com.example.projetgroupe.bo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Setter
@Getter
@Entity
public class Articles {

    @Id
    private long id;
    private LocalDate datePublication;
    private String titre;
    private String genre;
    private String categorie;
    private String description;
    private String etat;


}
