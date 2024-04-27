/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.tpbanquejess11.service;

import com.company.tpbanquejess11.entity.CompteBancaire;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author USER
 */
@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "java:app/jdbc/banque",
        serverName = "localhost",
        portNumber = 3306,
        user = "root",
        password = "root",
        databaseName = "banque",
        properties = {
            "useSSL=false",
            "allowPublicKeyRetrieval=true",
            "driverClass=com.mysql.cj.jdbc.Driver"
        }
)
@ApplicationScoped
public class GestionnaireCompte {

    @PersistenceContext(unitName = "banquePU")
    private EntityManager entityManager;

    /*  @Transactional
   * public void creerCompte(CompteBancaire c) {
    *    entityManager.persist(c);
    *}
     */
    @Transactional
    public void transferer(CompteBancaire source, CompteBancaire destination, int montant) {
        if (source != null && destination != null) {
            source.retirer(montant);
            destination.deposer(montant);
            update(source);
            update(destination);
        } else {
            throw new IllegalArgumentException("Un des comptes n'existe pas.");
        }
    }

    @Transactional
    public CompteBancaire update(CompteBancaire compteBancaire) {
        return entityManager.merge(compteBancaire);
    }

    @Transactional
    public void enregistrerCompte(CompteBancaire compte) {
        entityManager.persist(compte);
    }

    public CompteBancaire findById(long idCompte) {
        return entityManager.find(CompteBancaire.class, idCompte);
    }

    public List<CompteBancaire> getAllComptes() {
        TypedQuery<CompteBancaire> query
                = entityManager.createQuery("SELECT c FROM CompteBancaire c join fetch c.operations", CompteBancaire.class);
        return query.getResultList();
    }

    public long nbComptes() {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(c) FROM CompteBancaire c", Long.class);
        return query.getSingleResult();
    }

    @Transactional
    public void deposer(CompteBancaire compte, int montant) {
        compte.deposer(montant);
        update(compte);
    }

    @Transactional
    public void retirer(CompteBancaire compte, int montant) {
        compte.retirer(montant);
        update(compte);
    }

    @Transactional
    public void supprimerCompte(CompteBancaire compte) {
        entityManager.remove(entityManager.merge(compte));
    }

}
