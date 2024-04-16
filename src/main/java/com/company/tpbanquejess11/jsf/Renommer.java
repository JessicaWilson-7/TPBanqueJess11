/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.company.tpbanquejess11.jsf;

import com.company.tpbanquejess11.entity.CompteBancaire;
import com.company.tpbanquejess11.jsf.util.Util;
import com.company.tpbanquejess11.service.GestionnaireCompte;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;

/**
 *
 * @author USER
 */
@Named(value = "renommer")
@ViewScoped
public class Renommer implements Serializable {

    private Long id;
    private CompteBancaire compte;
    private String ancienNom;

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    /**
     * Creates a new instance of Renommer
     */
    public Renommer() {
    }

    public String renommerCompte() {
        gestionnaireCompte.update(compte);
        Util.addFlashInfoMessage("Nom " + ancienNom + " changé en " + compte.getNom());
        return "listeComptes?faces-redirect=true";
    }

    public void loadCompte() {
        compte = gestionnaireCompte.findById(id);
        ancienNom = compte.getNom();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }

}
