package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class EduMasterOverViewController extends AnchorPane {

    public EduMasterOverViewController() {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/FXML/EduMasterOverView.fxml"));
            fxml.setRoot(this);
            fxml.setController(this);
            fxml.load();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
