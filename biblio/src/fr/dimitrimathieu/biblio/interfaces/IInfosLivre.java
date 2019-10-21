package fr.dimitrimathieu.biblio.interfaces;

import fr.dimitrimathieu.biblio.entities.Livre;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IInfosLivre {
    List<fr.dimitrimathieu.biblio.entities.Livre> lister();

    Livre trouverParIsbn(String isbn);
}
