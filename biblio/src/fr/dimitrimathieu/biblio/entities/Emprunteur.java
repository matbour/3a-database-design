package fr.dimitrimathieu.biblio.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Emprunteur implements Serializable {
    @Id
    private int numemp;
    private String nom;
    private int nblivresemp;

    public Emprunteur() {
    }

    public Emprunteur(int numemp, String nom, int nblivreemp) {
        this.nom = nom;
        this.numemp = numemp;
        this.nblivresemp = nblivreemp;
    }

    public int getNumemp() {
        return numemp;
    }

    public void setNumemp(int numpem) {
        this.numemp = numpem;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNblivresemp() {
        return nblivresemp;
    }

    public void setNblivresemp(int nblivreemp) {
        this.nblivresemp = nblivreemp;
    }
}
