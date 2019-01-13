package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class EduStudentController extends AnchorPane {

    @FXML
    private AnchorPane content;

    public EduStudentController() {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/FXML/StudentPanel.fxml"));
            fxml.setRoot(this);
            fxml.setController(this);
            fxml.load();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

