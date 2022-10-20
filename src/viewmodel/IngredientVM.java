package viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Couleur;
import model.Ingredient;

public class IngredientVM {

    private StringProperty nom = new SimpleStringProperty();

    private ObjectProperty<NbVM> nb = new SimpleObjectProperty<>();

    private Ingredient model;

    public IngredientVM(Ingredient model) {
        this.model = model;
        nom.set(model.getNom());
        nb.set(new NbVM(model.getNb()));
    }

    public Ingredient getModel() {
        return model;
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

    public NbVM getNb() {
        return nb.get();
    }

    public ObjectProperty<NbVM> nbProperty() {
        return nb;
    }

    public void setNb(NbVM nb) {
        this.nb.set(nb);
    }
}
