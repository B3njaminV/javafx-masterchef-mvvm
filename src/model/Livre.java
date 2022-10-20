package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Livre implements Serializable {

    private List<Pate> listePate = new ArrayList<>();

    private transient PropertyChangeSupport support;

    public static final String PROPAJOUT = "model.ajouterPate";
    public static final String PROPSUPP = "model.supprimerPate";

    public Livre() {

    }

    public List<Pate> getListePate() {
        return Collections.unmodifiableList(listePate);
    }

    public void setListePate(List<Pate> listePate) {
        this.listePate = listePate;
    }

    public void ajouterPate(Pate p){
        listePate.add(p);
        getSupport().firePropertyChange(PROPAJOUT, null, p);
    }

    public void supprimerPate(Pate p){
        int index = listePate.indexOf(p);
        listePate.remove(p);
        getSupport().fireIndexedPropertyChange(PROPSUPP, index, p, null);
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
