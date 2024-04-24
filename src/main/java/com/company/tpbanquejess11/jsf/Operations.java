/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.company.tpbanquejess11.jsf;

import com.company.tpbanquejess11.entity.CompteBancaire;
import com.company.tpbanquejess11.entity.OperationBancaire;
import com.company.tpbanquejess11.service.GestionnaireCompte;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.util.List;

/**
 *
 * @author USER
 */
@Named(value = "operations")
@RequestScoped
public class Operations {

    private Long id;
    private CompteBancaire compte;

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    public List<OperationBancaire> getOperations() {
        return compte != null ? compte.getOperations() : null;
    }

    public void loadCompte() {
        compte = gestionnaireCompte.findById(id);
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
}
