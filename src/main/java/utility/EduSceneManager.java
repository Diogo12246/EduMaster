package utility;

import Controller.*;
import javafx.scene.layout.AnchorPane;


public class EduSceneManager {

    private static EduMasterCourseController courseController;
    private static EduMasterStudentController studentController;
    private static EduMasterOverViewController overviewController;
    private static EduMasterInstitutionController institutionController;
    private static EduMasterDisciplineController disciplineController;
    private static EduMasterProfessorController professorController;

    public static void getEduCourseManagement(AnchorPane box) {
        courseController = courseController == null ? new EduMasterCourseController() : courseController;
        config(box, courseController);
    }

    public static void getEduStudentManagement(AnchorPane box) {
        studentController = studentController == null ? new EduMasterStudentController() : studentController;
        config(box, studentController);
    }

    public static void getEduOverViewController(AnchorPane box){
        overviewController = overviewController == null ? new EduMasterOverViewController() : overviewController;
        config(box, overviewController);
    }

    public static void getEduMasterInstitutionController(AnchorPane box){
        institutionController = institutionController == null ? new EduMasterInstitutionController() : institutionController;
        config(box, institutionController);
    }

    public static void getEduDisciplineController(AnchorPane box) {
        disciplineController = disciplineController == null ? new EduMasterDisciplineController() : disciplineController;
        config(box,disciplineController);
    }

    public static void getEduProfessorController(AnchorPane box){
        professorController = professorController == null ? new EduMasterProfessorController() : professorController;
        config(box,professorController);
    }

    public static void config(AnchorPane box, AnchorPane content) {
        box.getChildren().clear();
        box.getChildren().add(content);
    }

}
