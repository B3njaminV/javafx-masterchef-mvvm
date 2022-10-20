package model;

import java.io.Serializable;

public class Couleur implements Serializable {

    private int rouge;
    private int bleu;
    private int vert;

    public Couleur(int rouge, int bleu, int vert) {
        this.rouge = rouge;
        this.bleu = bleu;
        this.vert = vert;
    }

    public int getRouge() {
        return rouge;
    }

    public void setRouge(int rouge) {
        this.rouge = rouge;
    }

    public int getBleu() {
        return bleu;
    }

    public void setBleu(int bleu) {
        this.bleu = bleu;
    }

    public int getVert() {
        return vert;
    }

    public void setVert(int vert) {
        this.vert = vert;
    }
}
