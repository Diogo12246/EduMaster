package application;


import ConnectionManager.ConnectionMasterBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utility.EduExceptionHandler;


public class EduLogin extends Application {

    public static Stage stage;
    private Scene scene;
    private AnchorPane page;
    private Screen ecra = Screen.getPrimary();
    private Rectangle2D window = ecra.getVisualBounds();

    public static void main(String[] args) {
        EduLogin.launch(EduLogin.class,(java.lang.String[]) null);
    }
    private double x, y;
    @Override
    public void start(Stage stage){
        try {
            EduMasterApp.stage= stage;
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/EduMasterLogin.fxml"));
            scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            root.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {

                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);

            });
            stage.show();
        }
        catch (Exception ex){
            EduExceptionHandler.ThrowEX(ex);
        }
    }

}

