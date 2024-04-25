/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.company.tpbanquejess11.jsf;

import com.company.tpbanquejess11.entity.CompteBancaire;
import com.company.tpbanquejess11.service.GestionnaireCompte;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

/**
 *
 * @author USER
 */
@FacesConverter(value = "compteConverter", managed = true)
public class CompteConverter implements Converter<CompteBancaire> {

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    /**
     * Convertit une String en Compte.
     *
     * @param value valeur à convertir
     */
    @Override
    public CompteBancaire getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        Long id = Long.valueOf(value);
        return gestionnaireCompte.findById(id);
    }

    /**
     * Convertit un Compte en String.
     *
     * @param value valeur à convertir
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, CompteBancaire compte) {
        if (compte == null) {
            return "";
        }
        return compte.getId().toString();
    }

}
