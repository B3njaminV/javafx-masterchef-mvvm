package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pate implements Serializable {

    private List<Ingredient> listeIngredient = new ArrayList<>();

    private transient PropertyChangeSupport support;

    public static final String PROP = "kjhghbjn";

    private String nom;

    public Pate(String nom) {
        this.nom = nom;
    }

    public List<Ingredient> getListeIngredient() {
        return Collections.unmodifiableList(listeIngredient);
    }

    public void setListeIngredient(List<Ingredient> listeIngredient) {
        this.listeIngredient = listeIngredient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void ajouterIngredient(Ingredient i){
        listeIngredient.add(i);
        getSupport().firePropertyChange(PROP, null, i);
    }

    public PropertyChangeSupport getSupport() {
        if(support == null){
            support = new PropertyChangeSupport(this);
        }
        return support;
    }

    public void ajouterListener(PropertyChangeListener listener){
        getSupport().addPropertyChangeListener(listener);
    }
}
