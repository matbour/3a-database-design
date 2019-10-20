package fr.dimitri.biblio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GestionEmprunt implements IGestionEmprunt {

    @PersistenceContext(unitName = "persistenceBiblio")
    protected EntityManager em;

    @Override
    public void emprunter(int num_emprunteur, String isbn) {
    }

    @Override
    public void rendre(String isbn) {
    }

}
