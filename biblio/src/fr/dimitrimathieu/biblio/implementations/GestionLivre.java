package fr.dimitrimathieu.biblio.implementations;

import fr.dimitrimathieu.biblio.entities.Livre;
import fr.dimitrimathieu.biblio.interfaces.IGestionLivre;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GestionLivre implements IGestionLivre {
    @PersistenceContext(unitName = "persistenceBiblio")
    protected EntityManager em;

    @Override
    public void nouveauLivre(String isbn, String titre) {
        Livre existant = em.find(Livre.class, isbn);

        if (existant == null) {
            em.persist(new Livre(isbn, titre));
        } else {
            // throw new PersistenceException("Le livre avec l'ISBN " + isbn + " existe déjà");
        }
    }

    @Override
    public void suppressionLivre(String isbn) {
        Livre existant = em.find(Livre.class, isbn);
        ;

        if (existant != null) {
            em.remove(existant);
        } else {
            // throw new PersistenceException("Le livre avec l'ISBN " + isbn + " existe déjà");
        }
    }
}
