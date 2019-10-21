package fr.dimitrimathieu.biblio.interfaces;

import javax.ejb.Remote;

@Remote
public interface IGestionLivre {
    void nouveauLivre(String isbn, String titre);

    void suppressionLivre(String isbn);
}
