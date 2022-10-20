package viewmodel;

import data.Loader;
import data.Stub;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Livre;
import model.Pate;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LivreVM implements PropertyChangeListener {

    private ObservableList<PateVM> listePateObs = FXCollections.observableArrayList();
    private SimpleListProperty<PateVM> listePate = new SimpleListProperty<>(listePateObs);

    private Livre model;

    public LivreVM() {
        try{
            this.model = new Loader().load();
        } catch (Exception e) {
            this.model = new Stub().load();
        }
        model.ajouterListener(this);
        model.getListePate().forEach(e -> listePateObs.add(new PateVM(e)));
    }

    public ObservableList<PateVM> getListePate() {
        return listePate.get();
    }

    public SimpleListProperty<PateVM> listePateProperty() {
        return listePate;
    }

    public void setListePate(ObservableList<PateVM> listePate) {
        this.listePate.set(listePate);
    }

    public Livre getModel() {
        return model;
    }

    public void ajouterPate(String txt){
        model.ajouterPate(new Pate(txt));
    }

    public void supprimerPate(PateVM pateVM){
        model.supprimerPate(pateVM.getModel());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(Livre.PROPAJOUT)){
            listePateObs.add(new PateVM((Pate) evt.getNewValue()));
        }
        if(evt.getPropertyName().equals(Livre.PROPSUPP)){
            listePateObs.remove(((IndexedPropertyChangeEvent)evt).getIndex());
        }
    }
}
