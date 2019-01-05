package utility;

//import Controller.PlanetCatalogController;
import Controller.EduCourseController;
import javafx.scene.layout.AnchorPane;


public class EduSceneManager {

    private static EduCourseController courseController;

    public static void getEduCourseManagement(AnchorPane box) {
        courseController = courseController == null ? new EduCourseController() : courseController;
        config(box, courseController);
    }

    public static void config(AnchorPane box, AnchorPane content) {
        box.getChildren().clear();
        box.getChildren().add(content);
    }
}
