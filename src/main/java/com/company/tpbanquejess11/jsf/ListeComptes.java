package com.company.tpbanquejess11.jsf;

import com.company.tpbanquejess11.entity.CompteBancaire;
import com.company.tpbanquejess11.service.GestionnaireCompte;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    @Inject
    private ColumnFilter columnFilter;

    public ListeComptes() {
    }

    public List<CompteBancaire> getAllComptes() {
        return gestionnaireCompte.getAllComptes();
    }

    public ColumnFilter getColumnFilter() {
        return columnFilter;
    }
}
