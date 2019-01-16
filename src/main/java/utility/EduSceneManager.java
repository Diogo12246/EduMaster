package utility;

//import Controller.PlanetCatalogController;
import Controller.EduCourseController;
import Controller.EduOverViewController;
import Controller.EduStudentController;
import javafx.scene.layout.AnchorPane;
import sun.plugin.javascript.navig.Anchor;


public class EduSceneManager {

    private static EduCourseController courseController;
    private static EduStudentController studentController;
    private static EduOverViewController overviewController;

    public static void getEduCourseManagement(AnchorPane box) {
        courseController = courseController == null ? new EduCourseController() : courseController;
        config(box, courseController);
    }

    public static void getEduStudentManagement(AnchorPane box) {
        studentController = studentController == null ? new EduStudentController() : studentController;
        config(box, studentController);
    }

    public static void getEduOverViewController(AnchorPane box){
        overviewController = overviewController == null ? new EduOverViewController() : overviewController;
        config(box, overviewController);
    }

    public static void config(AnchorPane box, AnchorPane content) {
        box.getChildren().clear();
        box.getChildren().add(content);
    }
}
