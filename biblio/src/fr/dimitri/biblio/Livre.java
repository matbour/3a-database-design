package fr.dimitri.biblio;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Livre implements Serializable {
    private String isbn;
    private String titre;

    Livre() {
    }

    Livre(String isbn, String titre) {
        this.isbn = isbn;
        this.titre = titre;
    }
}
