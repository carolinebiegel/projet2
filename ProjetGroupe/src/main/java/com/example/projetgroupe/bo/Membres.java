package com.example.projetgroupe.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@Data
public class Membres {

    @Id
    private String pseudo;
    private String password;

    private boolean admin;

    @OneToMany
    private List<Avis> avis;

    public Membres(String pseudo, String password, boolean admin) {
        this.pseudo = pseudo;
        this.password = password;
        this.admin = admin;
    }
}
