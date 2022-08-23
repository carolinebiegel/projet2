package com.example.projetgroupe.security;

import com.example.projetgroupe.bo.Membres;
import com.example.projetgroupe.service.MembresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * En créant une classe qui implémente l'interface de Spring Security : UserDetailsService
 * , Spring Security va comprendre que c'est à partir de cette classe (via sa méthode loadUserByUsername())
 * qu'il doit aller chercher les utilisateurs de l'application
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
	//List<Membres> ListeMembres = new ArrayList<>();


	private MembresService membresService;

	/**
	 * Au démarrage de l'application, je crée un utilisateur "admin"
	 */
	public MyUserDetailsService(MembresService membresService) {
		this.membresService = membresService;
		try {
			membresService.addMembres(new Membres("vanille", "fraise", true));
		} catch (Exception e) {
			System.out.println("Utilisateur admin déjà existant");
		}
	}




	/**
	 * loadUserByUsername(String username)
	 * => explique à Spring comment on lui retourne un utilisateur à partir d'un username utilisé dans la page de login
	 */
	@Override
	public UserDetails loadUserByUsername(String username) {

		// 1. Je recupère le membre qui correspond au username
		Membres membres = membresService.getMembresById(username);

		// Si jamais le membre est null, je lance une exception
		if (membres == null) {
			throw new UsernameNotFoundException(username);
		}
		// Sinon, je renvoie une instance de Utilisateur à partir de cet objet Membre
		else {
			return new Utilisateur(membres);
		}
	}

	

}