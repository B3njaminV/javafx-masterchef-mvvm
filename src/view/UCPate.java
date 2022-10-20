package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Nb;
import viewmodel.IngredientVM;
import viewmodel.NbVM;
import viewmodel.PateVM;

import java.io.IOException;
import java.util.Arrays;

public class UCPate extends AnchorPane {

    @FXML
    private ListView<IngredientVM> lv;
    @FXML
    private ColorPicker cp;
    @FXML
    private TextField tf;
    @FXML
    private ComboBox cb;

    public PateVM pateVM;

    public UCPate(PateVM pateVM) throws IOException {
        this.pateVM = pateVM;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UCIngredient.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    public void initialize(){
        cb.setItems(FXCollections.observableArrayList(Nb.values()));
        cb.getSelectionModel().selectFirst();
        lv.itemsProperty().bind(pateVM.listeIngredientProperty());
        lv.setCellFactory(__ -> new CelluleIngredient());
    }

    @FXML
    private void add(){
        pateVM.ajouterIngredient(tf.getText(), (Nb) cb.getSelectionModel().getSelectedItem());
    }
}
