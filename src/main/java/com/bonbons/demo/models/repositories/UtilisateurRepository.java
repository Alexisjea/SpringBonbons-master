package com.bonbons.demo.models.repositories;

import com.bonbons.demo.models.entities.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
     public Utilisateur findByEmail(String email);
}
