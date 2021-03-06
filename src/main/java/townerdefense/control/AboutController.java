package townerdefense.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import townerdefense.engine.GameConfig;
import townerdefense.model.MenuManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Initializable {

    @FXML
    private Button cancelButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void cancelButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(FXMLLoader.load(MenuManager.mainMenuUrl), GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT);

        stage.setScene(scene);

        stage.show();

        System.out.println("Cancel to Menu");
    }
}
