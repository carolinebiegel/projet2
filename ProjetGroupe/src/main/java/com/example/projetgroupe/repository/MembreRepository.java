package com.example.projetgroupe.repository;


import com.example.projetgroupe.bo.Membres;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CrudRepository a besoin de 2 parametres de types :
 * - le type de la classe pour laquelle on crée le repository : Todo
 * - le type de sont attribut annoté avec @Id : Long (wrapper autour de long qui ne peut etre utilisé dans une classe generique
 *
 * Spring va AUTOMATIQUEMENT créer une classe qui implémente cette
 * interface avec les méthodes save()/findAll()/etc...
 * et la rendre disponible dans le contexte comme un bean
 */

public interface MembreRepository extends JpaRepository<Membres, String> {

}
