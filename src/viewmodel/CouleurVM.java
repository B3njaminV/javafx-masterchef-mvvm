package viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;
import model.Couleur;


public class CouleurVM {

    private Couleur model;

    private ObjectProperty<Color> couleur = new SimpleObjectProperty<>();

    public CouleurVM(Couleur model) {
        this.model = model;
        couleur.set(new Color(model.getRouge()/255., model.getVert()/255., model.getBleu()/255., 1));
    }

    public Color getCouleur() {
        return couleur.get();
    }

    public ObjectProperty<Color> couleurProperty() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur.set(couleur);
    }

    public Couleur getModel() {
        return model;
    }
}
