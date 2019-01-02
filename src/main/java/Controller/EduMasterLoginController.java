package Controller;

import application.EduLogin;
import application.EduMasterApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EduMasterLoginController implements Initializable {

    EduMasterManager manager = new EduMasterManager();
    @FXML private Button exitBtn;
    @FXML private Button loginBtn;
    private static EduMasterLoginController instance;


    public static EduMasterLoginController getInstance() {
        return instance;
    }

    @FXML
    private void exitAPP(){
        Stage stage = (Stage)exitBtn.getScene().getWindow();
        stage.close();
    }

    @FXML void Login(ActionEvent event) {
        Stage stage = (Stage)loginBtn.getScene().getWindow();
        stage.close();
        new EduMasterApp().start(new Stage());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
