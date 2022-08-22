package com.example.projetgroupe.bo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Setter
@Getter
@Entity
public class Categories {

    @Id
    private long id;
    private String libelle;


}
