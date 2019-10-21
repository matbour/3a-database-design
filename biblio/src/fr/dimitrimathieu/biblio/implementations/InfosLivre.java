package fr.dimitrimathieu.biblio.implementations;

import fr.dimitrimathieu.biblio.interfaces.IInfosLivre;
import fr.dimitrimathieu.biblio.entities.Livre;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class InfosLivre implements IInfosLivre {
    @PersistenceContext(unitName = "persistenceBiblio")
    protected EntityManager em;

    @Override
    public List<fr.dimitrimathieu.biblio.entities.Livre> lister() {
        TypedQuery<fr.dimitrimathieu.biblio.entities.Livre> query = em.createNamedQuery("Livre.lister", fr.dimitrimathieu.biblio.entities.Livre.class);
        return query.getResultList();
    }

    @Override
    public fr.dimitrimathieu.biblio.entities.Livre trouverParIsbn(String isbn) {
        TypedQuery<fr.dimitrimathieu.biblio.entities.Livre> query = em.createNamedQuery("Livre.trouverParIsbn", Livre.class);
        query.setParameter("isbn", isbn);
        return query.getSingleResult();
    }
}
