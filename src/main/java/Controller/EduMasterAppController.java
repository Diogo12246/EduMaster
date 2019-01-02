package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
//import Controller.PlanetCatalogController;


public class EduMasterAppController implements Initializable {


    private static EduMasterAppController instance;

    @FXML private AnchorPane content;
    @FXML private Button exitBtn;
    @FXML private Label labelUser;

    public AnchorPane getContent() {
        return content;
    }

    public static EduMasterAppController getInstance() {
        return instance;
    }

    @FXML
    private void exitAPP(){
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelUser.setText(EduMasterLoginController.getUserInstance());
    }
}

    /*
   @FXML
    void planetCatalog(ActionEvent event) {
        //EduSceneManager.getPlanetCatalogController(content);
    }*/

