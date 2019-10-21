package fr.dimitrimathieu.biblio.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "livre_emp")
public class LivreEmp implements Serializable {
    @Id private String isbn;
    private String titre;
    private int empruntepar;

    public LivreEmp() {
    }

    public LivreEmp(String isbn, String titre, int empruntepar) {
        this.isbn = isbn;
        this.titre = titre;
        this.empruntepar = empruntepar;
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

    public int getEmpruntepar() {
        return empruntepar;
    }

    public void setEmpruntepar(int empruntepar) {
        this.empruntepar = empruntepar;
    }
}
