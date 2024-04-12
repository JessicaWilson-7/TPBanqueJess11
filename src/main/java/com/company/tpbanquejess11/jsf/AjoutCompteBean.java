/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.company.tpbanquejess11.jsf;

import com.company.tpbanquejess11.entity.CompteBancaire;
import com.company.tpbanquejess11.jsf.util.Util;
import com.company.tpbanquejess11.service.GestionnaireCompte;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

/**
 *
 * @author USER
 */
@Named(value = "ajoutCompteBean")
@RequestScoped
public class AjoutCompteBean {

    private String nom;
    private int solde; 

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    /**
     * Creates a new instance of AjoutCompteBean
     */
    public AjoutCompteBean() {
    }

    public String creerCompte() {
        if (nom == null || nom.isEmpty()) {
            Util.addErrorMessage("Veuillez saisir un nom de titulaire valide.");
            return null;
        }

        if (solde < 0) {
            Util.addErrorMessage("Le solde ne peut pas être négatif.");
            return null;
        }

        CompteBancaire nouveauCompte = new CompteBancaire();
        nouveauCompte.setNom(nom);
        nouveauCompte.setSolde(solde);

        gestionnaireCompte.enregistrerCompte(nouveauCompte);

        Util.addSuccessMessage("Le compte a été créé avec succès.");

        return "listeComptes?faces-redirect=true";
    }

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }
}
