package fr.dimitri.biblio;

import javax.ejb.Remote;

@Remote
public interface IGestionEmprunt {

    void emprunter(int num_emprunteur, String isbn);

    void rendre(String isbn);
}
