package view;

import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import viewmodel.IngredientVM;

import java.io.IOException;

public class CelluleIngredient extends ListCell<IngredientVM> {

    @Override
    protected void updateItem(IngredientVM ingredientVM, boolean b) {
        super.updateItem(ingredientVM, b);
        if(!b){
            try{
                setGraphic(new UCListIngredient(ingredientVM));
            } catch (IOException e) {
                textProperty().bind(ingredientVM.nomProperty());
            }
        }else {
            textProperty().unbind();
            setGraphic(null);
            setText("");
        }
    }
}
