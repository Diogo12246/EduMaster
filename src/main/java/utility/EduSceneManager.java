package utility;

import Controller.*;
import javafx.scene.layout.AnchorPane;


public class EduSceneManager {

    private EduMasterCourseController courseController;
    private EduMasterStudentController studentController;
    private EduMasterOverViewController overviewController;
    private EduMasterInstitutionController institutionController;
    private EduMasterDisciplineController disciplineController;
    private EduMasterProfessorController professorController;
    private EduMasterTuitionController tuitionController;

    public void getEduCourseManagement(AnchorPane box) {
        courseController = courseController == null ? new EduMasterCourseController() : courseController;
        config(box, courseController);
    }

    public void getEduStudentManagement(AnchorPane box) {
        studentController = studentController == null ? new EduMasterStudentController() : studentController;
        config(box, studentController);
    }

    public void getEduOverViewController(AnchorPane box){
        overviewController = overviewController == null ? new EduMasterOverViewController() : overviewController;
        config(box, overviewController);
    }

    public void getEduMasterInstitutionController(AnchorPane box){
        institutionController = institutionController == null ? new EduMasterInstitutionController() : institutionController;
        config(box, institutionController);
    }

    public void getEduDisciplineController(AnchorPane box) {
        disciplineController = disciplineController == null ? new EduMasterDisciplineController() : disciplineController;
        config(box,disciplineController);
    }

    public void getEduProfessorController(AnchorPane box){
        professorController = professorController == null ? new EduMasterProfessorController() : professorController;
        config(box,professorController);
    }

    public void getEduTuitionController(AnchorPane box) {
        tuitionController = tuitionController == null ? new EduMasterTuitionController() : tuitionController;
        config(box,tuitionController);
    }

    public static void config(AnchorPane box, AnchorPane content) {
        box.getChildren().clear();
        box.getChildren().add(content);
    }


}
