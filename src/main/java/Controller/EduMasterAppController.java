package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//import Controller.PlanetCatalogController;


public class EduMasterAppController {

    private static EduMasterAppController instance;

    @FXML private AnchorPane content;
    @FXML private Button exitBtn;

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



}

    /*
   @FXML
    void planetCatalog(ActionEvent event) {
        //EduSceneManager.getPlanetCatalogController(content);
    }

    @FXML
    private void exitAPP(){

    }*/
