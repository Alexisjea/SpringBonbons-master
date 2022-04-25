package com.bonbons.demo.controller;

import com.bonbons.demo.models.entities.Produit;
import com.bonbons.demo.services.ProduitService;
import com.bonbons.demo.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class IndexController {

    @Autowired
    private ProduitService produitService;

    private UtilisateurService utilisateurService;

    @GetMapping("/")
    public String index(Model model){
        List<Produit> bonbons = produitService.all();
        model.addAttribute("produits", bonbons);
        return "pageProduits";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register (Model model){
        utilisateurService.register("admin@ledoo.fr", "admin123");

    }
}
