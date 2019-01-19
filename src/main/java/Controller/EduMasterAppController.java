package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utility.EduSceneManager;

import java.net.URL;
import java.util.ResourceBundle;


public class EduMasterAppController implements Initializable {


    private static EduMasterAppController instance;

    @FXML
    private AnchorPane content;
    @FXML
    private Button exitBtn;
    @FXML
    private Label labelUser;
    @FXML
    private GridPane gridpaneAPP;
    @FXML
    private Button overviewBtn;
    @FXML
    private Button studentsBtn;
    @FXML
    private Button lecturersBtn;
    @FXML
    private Button institutionsBtn;
    @FXML
    private Button coursesBtn;
    @FXML
    private Button disciplinesBtn;
    @FXML
    private Button tuitionsBtn;

    public AnchorPane getContent() {
        return content;
    }

    public static EduMasterAppController getInstance() {
        return instance;
    }

    @FXML
    private void exitAPP() {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void CourseManagement() {
        EduSceneManager manager = new EduSceneManager();
        manager.getEduCourseManagement(content);
    }

    @FXML
    void StudentManagement() {
        EduSceneManager manager = new EduSceneManager();
        manager.getEduStudentManagement(content);
    }

    @FXML
    void InstitutionManagement() {
        EduSceneManager manager = new EduSceneManager();
        manager.getEduMasterInstitutionController(content);
    }

    @FXML
    void DisciplineManagement(){
        EduSceneManager manager = new EduSceneManager();
        manager.getEduDisciplineController(content);
    }

    @FXML
    void ProfessorManagement(){
        EduSceneManager manager = new EduSceneManager();
        manager.getEduProfessorController(content);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelUser.setText(EduMasterLoginController.getUserInstance());
        gridpaneAPP.setStyle("-fx-background-image: url(../resources/styles/images/SplashS2.jpg)");
        overviewManagement();
    }

    @FXML
    private void overviewManagement() {
        EduSceneManager manager = new EduSceneManager();
        manager.getEduOverViewController(content);
    }
}



