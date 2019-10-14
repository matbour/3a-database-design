package fr.dimitri.biblio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GestionLivre implements IGestionLivre {

    @PersistenceContext(unitName = "persistenceBiblio")
    protected EntityManager em;

    @Override
    public void nouveauLive(String isbn, String titre) {
        em.persist(new Livre(isbn, titre));
    }
}
