package com.bonbons.demo.services;


import com.bonbons.demo.models.entities.Utilisateur;
import com.bonbons.demo.models.repositories.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {


    private UtilisateurRepository utilisateurRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Ré&cupérer son utilisateur par son email
        Utilisateur utilisateur = utilisateurRepository.findByEmail(username);
        // si l'utilisateur est null
        if(utilisateur== null ){
            // alors boom un message d'erreur = exception
            throw new UsernameNotFoundException("Utilisateur introuvable");
        }
        // Instancier un Set de permission
        Set< GrantedAuthority> listeDePermissions = new HashSet<GrantedAuthority>();
        // Affecter un role il y a 2 manières

//        String nomRole=utilisateur.getRole().getNom();
//        GrantedAuthority unePermission = new SimpleGrantedAuthority(nomRole);
//        listeDePermissions.add(unePermission);
    // On ajoute une permission a une liste de permission
        // La permission que l'on ajoute correspond au nom du role de l'utilisateur

        //------------------------- OU -----------------------------------
        listeDePermissions.add(new SimpleGrantedAuthority(utilisateur.getRole().getNom()));

        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println("PASSWORD = "+bCryptPasswordEncoder.encode(utilisateur.getMdp()));
        // On retourne un User (de user details) avec un login un mdp et un listdepermission
        return new User(utilisateur.getEmail(),utilisateur.getMdp(), listeDePermissions);

    }
}
