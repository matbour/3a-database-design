package fr.dimitrimathieu.biblio.implementations;

import fr.dimitrimathieu.biblio.entities.Emprunteur;
import fr.dimitrimathieu.biblio.entities.Livre;
import fr.dimitrimathieu.biblio.entities.LivreEmp;
import fr.dimitrimathieu.biblio.exceptions.LivreDejaEmprunte;
import fr.dimitrimathieu.biblio.exceptions.NbMaxEmpruntsAtteint;
import fr.dimitrimathieu.biblio.interfaces.IGestionEmprunt;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GestionEmprunt implements IGestionEmprunt {
    private int MAX_EMPRUNTS;

    @PersistenceContext(unitName = "persistenceBiblio")
    protected EntityManager em;

    @Override
    public void emprunter(int num_emprunteur, String isbn) throws NbMaxEmpruntsAtteint, LivreDejaEmprunte {
        Emprunteur emprunteur = em.find(Emprunteur.class, num_emprunteur);

        if (emprunteur == null) {
            // throw
        } else if (emprunteur.getNblivresemp() >= MAX_EMPRUNTS) {
            throw new NbMaxEmpruntsAtteint(emprunteur, MAX_EMPRUNTS);
        }

        Livre livre = em.find(Livre.class, isbn);

        if (livre == null) {
            // throw
        } else if (livre.getDispo() == 0) {
            throw new LivreDejaEmprunte(livre);
        }

        // Création de l'emprunt
        LivreEmp livreEmp = new LivreEmp(livre.getIsbn(), livre.getTitre(), emprunteur.getNumemp());
        em.persist(livreEmp);

        // Mise à jour de la disponibilité du livre
        livre.setDispo(0);
        em.persist(livre);

        // Mise à jour du compteur de l'emprunteur
        emprunteur.setNblivresemp(emprunteur.getNblivresemp() + 1);
        em.persist(emprunteur);
    }

    @Override
    public void rendre(String isbn) {
        LivreEmp livreEmp = em.find(LivreEmp.class, isbn);

        if (livreEmp == null) {
            return;
        }

        // Mise à jour de la disponibilité du livre
        Livre livre = em.find(Livre.class, isbn);
        livre.setDispo(1);
        em.persist(livre);

        // Mise à jour du compteur de l'emprunteur
        Emprunteur emprunteur = em.find(Emprunteur.class, livreEmp.getEmpruntepar());
        emprunteur.setNblivresemp(emprunteur.getNblivresemp() - 1);
        em.persist(emprunteur);

        // Supression de l'emprunt
        em.remove(livreEmp);
    }

}
