package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import viewmodel.LivreVM;
import viewmodel.PateVM;

import java.io.IOException;

public class FenetrePrincipale {

    @FXML
    private ListView<PateVM> lv;

    @FXML
    private AnchorPane ap;

    @FXML
    private TextField tf;

    private LivreVM viewmodel;

    public FenetrePrincipale(LivreVM livreVM) {
        this.viewmodel = livreVM;
    }

    public void initialize(){
        lv.itemsProperty().bind(viewmodel.listePateProperty());
        lv.setCellFactory(__ -> new CellulePate());
        lv.getSelectionModel().selectedItemProperty().addListener((__, oldV, newV) -> {
            if (oldV != null){
                tf.textProperty().unbindBidirectional(oldV.nomProperty());
                ap.getChildren().clear();
            }
            if(newV != null){
                tf.textProperty().bindBidirectional(newV.nomProperty());
                try {
                    ap.getChildren().add(new UCPate(newV));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @FXML
    private void add(ActionEvent actionEvent) {
        viewmodel.ajouterPate("inconnu");
    }

    @FXML
    private void delete(ActionEvent actionEvent) {
        viewmodel.supprimerPate(lv.getSelectionModel().getSelectedItem());
    }
}
