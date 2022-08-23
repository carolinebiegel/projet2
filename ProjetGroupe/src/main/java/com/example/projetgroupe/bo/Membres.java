package com.example.projetgroupe.bo;

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

    @OneToMany
    private List<Avis> avis;


}
