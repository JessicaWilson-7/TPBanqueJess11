/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.tpbanquejess11.jsf;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.Locale;

/**
 *
 * @author USER
 */
@Named(value = "columnFilter")
@ApplicationScoped
public class ColumnFilter {

    public boolean filterBySolde(Object solde, Object filterValue, Locale locale) {
        if (solde == null || filterValue == null) {
            return false;
        }

        try {
            Integer soldeInt = (Integer) solde;
            Integer filterValueInt = Integer.valueOf((String) filterValue);

            return soldeInt >= filterValueInt;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
