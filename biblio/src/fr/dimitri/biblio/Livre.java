package fr.dimitri.biblio;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Livre implements Serializable {
    @Id
    private String isbn;
    private String titre;
    private int dispo;

    public Livre() {
    }

    public Livre(String isbn, String titre) {
        this.isbn = isbn;
        this.titre = titre;
        this.dispo = 1;
    }
}
