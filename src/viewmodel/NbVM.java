package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Nb;

public class NbVM {

    private StringProperty nb = new SimpleStringProperty();

    private Nb model;

    public NbVM(Nb model) {
        this.model = model;
        this.nb.set(model.toString());
    }

    public String getNb() {
        return nb.get();
    }

    public StringProperty nbProperty() {
        return nb;
    }

    public void setNb(String nb) {
        this.nb.set(nb);
    }

    public Nb getModel() {
        return model;
    }

    public static Nb[] getEnumeration() {
        return Nb.values();
    }

    @Override
    public String toString() {
        return nb.getValue();
    }
}
