package fr.dimitrimathieu.biblio.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@Entity
@NamedQueries({
    @NamedQuery(name = "Livre.lister", query = "select l from Livre l"),
    @NamedQuery(name = "Livre.trouverParIsbn", query = "select l from Livre l where l.isbn = :isbn")
})
public class Livre implements Serializable {
    @Id
    private String isbn;
    private String titre;
    private int dispo = 1;

    public Livre(String isbn, String titre) {
        this.isbn = isbn;
        this.titre = titre;
    }

    public Livre() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDispo() {
        return dispo;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    public String toString() {
        return String.format("%s (ISBN: %s) - %s", titre, isbn, dispo == 0 ? "emprunté" : "disponible");
    }
}
