package com.bonbons.demo.services;

import com.bonbons.demo.models.entities.Utilisateur;
import com.bonbons.demo.models.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UtilisateurService {
    @Autowired
    private ProduitService produitService;

    @Autowired
    private RoleRepository roleRepository;



    public  void register(String email , String mdp){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setMdp(utilisateur.getMdp());
        utilisateur.setEmail(utilisateur.getEmail());
        utilisateur.setNom(utilisateur.getNom());
        utilisateur.setPrenom(utilisateur.getPrenom());
    }

}
