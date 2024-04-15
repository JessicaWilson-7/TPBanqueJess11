/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.tpbanquejess11.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class CompteBancaire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private int solde;

    public CompteBancaire() {
    }

    public CompteBancaire(String nom, int solde) {
        this.nom = nom;
        this.solde = solde;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void deposer(int montant) {
        this.solde += montant;
    }

    public void retirer(int montant) {
        if (this.solde >= montant) {
            this.solde -= montant;
        } else {
            throw new IllegalArgumentException("Le solde du compte est insuffisant pour effectuer le retrait.");
        }
    }

    public int consulterSolde() {
        return solde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CompteBancaire)) {
            return false;
        }
        CompteBancaire other = (CompteBancaire) object;
        return id != null && id.equals(other.id);
    }

    @Override
    public String toString() {
        return "com.company.tpbanquejess11.entity.CompteBancaire[ id=" + id + " ]";
    }
}
