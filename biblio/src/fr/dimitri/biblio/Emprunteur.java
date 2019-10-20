package fr.dimitri.biblio;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Emprunteur implements Serializable {

    @Id
    private int numpem;
    private String nom;
    private int nblivreemp;

   public Emprunteur() {
    }

    Emprunteur(int numpem, String nom) {
        this.nom = nom;
        this.numpem = numpem;
        nblivreemp = 0;
    }
}
