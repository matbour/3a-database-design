package fr.dimitrimathieu.biblio.interfaces;

import fr.dimitrimathieu.biblio.exceptions.LivreDejaEmprunte;
import fr.dimitrimathieu.biblio.exceptions.NbMaxEmpruntsAtteint;

import javax.ejb.Remote;

@Remote
public interface IGestionEmprunt {

    void emprunter(int num_emprunteur, String isbn) throws NbMaxEmpruntsAtteint, LivreDejaEmprunte;

    void rendre(String isbn);
}
