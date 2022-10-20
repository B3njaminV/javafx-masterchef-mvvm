package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Ingredient;
import model.Nb;
import model.Pate;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PateVM implements PropertyChangeListener {

    private ObservableList<IngredientVM> listeIngredientObs = FXCollections.observableArrayList();
    private ListProperty<IngredientVM> listeIngredient = new SimpleListProperty<>(listeIngredientObs);

    private StringProperty nom = new SimpleStringProperty();

    private Pate model;

    public PateVM(Pate model) {
        this.model = model;
        this.nom.set(model.getNom());
        this.model.ajouterListener(this);
        this.nom.addListener((__, ___, newV) -> model.setNom(newV));
        model.getListeIngredient().forEach(e -> listeIngredientObs.add(new IngredientVM(e)));
    }

    public ObservableList<IngredientVM> getListeIngredient() {
        return listeIngredient.get();
    }

    public ListProperty<IngredientVM> listeIngredientProperty() {
        return listeIngredient;
    }

    public void setListeIngredient(ObservableList<IngredientVM> listeIngredient) {
        this.listeIngredient.set(listeIngredient);
    }

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public Pate getModel() {
        return model;
    }

    public void ajouterIngredient(String txt, Nb nb){
        model.ajouterIngredient(new Ingredient(txt, nb));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(Pate.PROP)){
            listeIngredientObs.add(new IngredientVM((Ingredient) evt.getNewValue()));
        }
    }
}
