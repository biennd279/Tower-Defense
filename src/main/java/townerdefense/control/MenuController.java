package townerdefense.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import townerdefense.engine.GameConfig;
import townerdefense.model.MenuManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    private static Stage stage;
    @FXML
    private AnchorPane root;
    @FXML
    private Button aboutButton;
    @FXML
    private Button continueButton;
    @FXML
    private Button newGameButton;
    @FXML
    private Button settingButton;
    @FXML
    private Button exitButton;
    private FXMLLoader fxmlLoader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Font.loadFont(this.getClass().getResource("/fonts/Freedom-nZ4J.otf").toExternalForm(), 12);
        fxmlLoader = new FXMLLoader();
    }

    @FXML
    protected void handleContinueButtonAction(ActionEvent event) throws IOException {
        loadNewScene(MenuManager.gameUrl);

        GameController gameController = fxmlLoader.getController();

        gameController.loadLastPlay();

        stage.show();

        System.out.println("Load Scene...");
    }

    @FXML
    public void handleNewGameButton(ActionEvent event) throws IOException {
        loadNewScene(MenuManager.gameUrl);

        GameController gameController = fxmlLoader.getController();

        gameController.startNewGame();

        stage.show();

        System.out.println("Load Scene...");
    }

    @FXML
    public void handleAboutButtonAction(ActionEvent event) throws IOException {
        loadNewScene(MenuManager.aboutUrl);

        stage.show();
    }

    @FXML
    public void handleExitButtonAction(ActionEvent event) {
        stage.close();
    }

    @FXML
    public void handleSettingButtonAction(ActionEvent event) throws IOException {

        loadNewScene(MenuManager.settingUrl);

        stage.show();

        System.out.println("Go to SettingManager!");
    }

    public void setStage(Stage stage) {
        MenuController.stage = stage;
    }

    private void loadNewScene(URL url) throws IOException {
        fxmlLoader = new FXMLLoader(url);
        stage.setScene(new Scene(fxmlLoader.load(), GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT));
    }
}
