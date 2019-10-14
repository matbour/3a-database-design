package fr.dimitri.biblio;

import javax.ejb.Remote;

@Remote
public interface IGestionLivre {
    void nouveauLive(String isbn, String titre);
}
