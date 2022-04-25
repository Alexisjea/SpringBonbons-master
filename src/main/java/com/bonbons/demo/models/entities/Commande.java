/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package com.bonbons.demo.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;


@Getter
@Setter
@NoArgsConstructor

public class Commande {

    private long id;


    private Date dateCommande;


    private String statut;

    private Utilisateur commandes;

    private List<Inventaire> lignes = new ArrayList<Inventaire>();


}