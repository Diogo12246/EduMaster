package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class EduCourseController extends AnchorPane {

    @FXML
    private AnchorPane content;

    public EduCourseController() {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/FXML/CoursePanel.fxml"));
            fxml.setRoot(this);
            fxml.setController(this);
            fxml.load();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

