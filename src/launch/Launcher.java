package launch;

import data.Saver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.FenetrePrincipale;
import viewmodel.LivreVM;

public class Launcher extends Application {

    private LivreVM livreVM = new LivreVM();

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FenetrePrincipale.fxml"));
        loader.setController(new FenetrePrincipale(livreVM));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        new Saver().save(livreVM.getModel());
    }
}
