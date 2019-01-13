package utility;

//import Controller.PlanetCatalogController;
import Controller.EduCourseController;
import Controller.EduStudentController;
import javafx.scene.layout.AnchorPane;


public class EduSceneManager {

    private static EduCourseController courseController;
    private static EduStudentController studentController;

    public static void getEduCourseManagement(AnchorPane box) {
        courseController = courseController == null ? new EduCourseController() : courseController;
        config(box, courseController);
    }

    public static void getEduStudentManagement(AnchorPane box) {
        studentController = studentController == null ? new EduStudentController() : studentController;
        config(box, studentController);
    }

    public static void config(AnchorPane box, AnchorPane content) {
        box.getChildren().clear();
        box.getChildren().add(content);
    }
}
