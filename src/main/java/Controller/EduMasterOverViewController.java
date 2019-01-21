package Controller;

import Model_DAO.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EduMasterOverViewController extends AnchorPane implements Initializable {

    @FXML
    private ProgressBar revenueValue;
    @FXML
    private ProgressBar totalCourses;
    @FXML
    private ProgressBar totalStudents;
    @FXML
    private ProgressBar totalInstitutions;
    @FXML
    private ProgressBar totalProfessors;
    @FXML
    private Label courseCount;
    @FXML
    private Label studentCount;
    @FXML
    private Label institutionCount;
    @FXML
    private Label professorCount;
    @FXML
    private Label revenueCount;

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TuitionDAO daoTuition = new TuitionDAO();
        StudentDAO daoStudent = new StudentDAO();
        CourseDAO daoCourse = new CourseDAO();
        InstitutionDAO daoInstitution = new InstitutionDAO();
        ProfessorDAO daoProfessor = new ProfessorDAO();


        double progressRevenue = daoTuition.getTuitionsRevenuePercentage();
        double progressStudents = daoStudent.getStudentCountProgress();
        double progressProfessors = daoProfessor.getProfessorProgress();
        double progressInstitutions = daoInstitution.getInstitutionProgress();
        double progressCourses = daoCourse.getCoursesProgress();

        String revenueCountEuro = daoTuition.getTuitionsRevenue();
        String studentCountNumb = daoStudent.getStudentCount();
        String professorCountNumb = daoProfessor.getProfessorCount();
        String institutionCountNumb = daoInstitution.getInstitutionCount();
        String coursesCountNumb = daoCourse.getCoursesCount();

        revenueValue.setProgress(progressRevenue);
        totalStudents.setProgress(progressStudents);
        totalInstitutions.setProgress(progressInstitutions);
        totalProfessors.setProgress(progressProfessors);
        totalCourses.setProgress(progressCourses);

        revenueCount.setText(revenueCountEuro + " €");
        studentCount.setText(studentCountNumb + " / 10000");
        professorCount.setText(professorCountNumb + " / 1000");
        institutionCount.setText(institutionCountNumb + " / 100");
        courseCount.setText(coursesCountNumb + " / 1000");
    }
}
