package model;

import java.io.Serializable;

public class Ingredient implements Serializable {

    private String nom;

    private Couleur couleur;

    private Nb nb;

    public Ingredient(String nom, Nb nb) {
        this.nom = nom;
        this.nb = nb;
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public Nb getNb() {
        return nb;
    }

    public void setNb(Nb nb) {
        this.nb = nb;
    }
}
