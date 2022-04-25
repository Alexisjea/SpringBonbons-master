package com.bonbons.demo.models.repositories;

import com.bonbons.demo.models.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
//    public List<Produit> findAllOrderByCategorieNomAscAndNomAsc();



}