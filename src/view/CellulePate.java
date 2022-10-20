package view;

import javafx.scene.control.ListCell;
import viewmodel.PateVM;

import java.io.IOException;

public class CellulePate extends ListCell<PateVM> {

    @Override
    protected void updateItem(PateVM pateVM, boolean b) {
        super.updateItem(pateVM, b);
        if(!b){
            try{
                setGraphic(new UCListPate(pateVM));
            } catch (IOException e) {
                textProperty().bind(pateVM.nomProperty());
            }
        }else{
            textProperty().unbind();
            setGraphic(null);
            setText("");
        }
    }
}
