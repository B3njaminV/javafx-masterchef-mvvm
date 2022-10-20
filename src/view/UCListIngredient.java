package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import viewmodel.IngredientVM;

import java.io.IOException;

public class UCListIngredient extends BorderPane {

    @FXML
    private Rectangle rect;

    @FXML
    private Text text;

    @FXML
    private Text nb;

    private IngredientVM ingredientVM;

    public UCListIngredient(IngredientVM ivm) throws IOException {
        this.ingredientVM = ivm;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UCListIngredient.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    public void initialize(){
        text.textProperty().bind(ingredientVM.nomProperty());
        nb.textProperty().bind(ingredientVM.nbProperty().asString());
    }
}
