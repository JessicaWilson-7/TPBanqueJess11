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
@Named(value = "transfertBean")
@RequestScoped
public class TransfertBean {

    private Long idSource;
    private Long idDestination;
    private Integer montant;

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    /**
     * Creates a new instance of TransfertBean
     */
    public TransfertBean() {
    }

    public Long getIdSource() {
        return idSource;
    }

    public void setIdSource(Long idSource) {
        this.idSource = idSource;
    }

    public Long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(Long idDestination) {
        this.idDestination = idDestination;
    }

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    public String transfererArgent() {
        boolean erreur = false;
        CompteBancaire source = gestionnaireCompte.findById(idSource);
        if (source == null) {
            Util.addErrorMessage("Aucun compte avec cet id !");
            erreur = true;
        } else {
            if (source.getSolde() < montant) {
                Util.addErrorMessage("Solde insuffisant dans le compte source !");
                erreur = true;
            }
        }

        if (erreur) {
            return null;
        }

        CompteBancaire destination = gestionnaireCompte.findById(idDestination);
        gestionnaireCompte.transferer(source, destination, montant);
        Util.addSuccessMessage("Transfert correctement effectué");
        return "listeComptes?faces-redirect=true";
    }
}
