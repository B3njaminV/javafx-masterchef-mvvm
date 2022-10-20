package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import viewmodel.PateVM;

import java.io.IOException;

public class UCListPate extends VBox {

    @FXML
    private Text text;

    private PateVM pateVM;

    public UCListPate(PateVM pa) throws IOException {
        this.pateVM = pa;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UCListPate.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }
    public void initialize(){
        text.textProperty().bind(pateVM.nomProperty());
    }
}
