package com.bonbons.demo.services;

import com.bonbons.demo.models.entities.Produit;
import com.bonbons.demo.models.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> all(){
        return  produitRepository.findAll();
    }

}
