package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class EduOverViewController extends AnchorPane {

    public EduOverViewController()
    {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/FXML/OverView.fxml"));
            fxml.setRoot(this);
            fxml.setController(this);
            fxml.load();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }




}
