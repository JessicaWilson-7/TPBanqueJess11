/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.tpbanquejess11.config;

import com.company.tpbanquejess11.entity.CompteBancaire;
import com.company.tpbanquejess11.service.GestionnaireCompte;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import jakarta.transaction.Transactional;
import java.util.List;

import java.util.logging.Logger;

/**
 *
 * @author USER
 */
@ApplicationScoped
public class Init {

    private final static Logger logger = Logger.getLogger("com.company.tpbanquejess11.config.Init");

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    @Transactional
    public void init(@Observes @Initialized(ApplicationScoped.class) ServletContext context) {
        List<CompteBancaire> comptes = gestionnaireCompte.getAllComptes();
        if (comptes.isEmpty()) {
            logger.warning("Aucun compte dans la base de données. Création de comptes");
            gestionnaireCompte.enregistrerCompte(new CompteBancaire("John Lennon", 150000));
            gestionnaireCompte.enregistrerCompte(new CompteBancaire("Paul McCartney", 950000));
            gestionnaireCompte.enregistrerCompte(new CompteBancaire("Ringo Starr", 20000));
            gestionnaireCompte.enregistrerCompte(new CompteBancaire("Georges Harrisson", 100000));
        }else{
            logger.info("La base de données n'est pas vide");
        }
    }
}
