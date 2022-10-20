package data;

import model.Livre;
import model.Pate;

public class Stub implements ILoader{
    @Override
    public Livre load() {
        Livre l = new Livre();
        l.ajouterPate(new Pate("TEXT"));
        l.ajouterPate(new Pate("TEXT"));
        l.ajouterPate(new Pate("TEXT"));
        l.ajouterPate(new Pate("TEXT"));
        l.ajouterPate(new Pate("TEXT"));
        return l;
    }
}
