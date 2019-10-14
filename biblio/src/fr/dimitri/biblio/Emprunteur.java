package fr.dimitri.biblio;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Emprunteur implements Serializable {

    private String name;
    private int num_emprunteur;
    private int livre_number;

    Emprunteur() {

    }

    Emprunteur(int id, String name) {
        this.name = name;
        this.num_emprunteur = id;
    }
}
