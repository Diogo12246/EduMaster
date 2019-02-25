package pt.diogo12246.Controller;

import pt.diogo12246.Model_DAO.*;
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

    /*
    THIS CONTROLLER IS BUGGY!!!! create records in all fields in order to work.
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TuitionDAO daoTuition = new TuitionDAO();
        StudentDAO daoStudent = new StudentDAO();
        CourseDAO daoCourse = new CourseDAO();
        InstitutionDAO daoInstitution = new InstitutionDAO();
        ProfessorDAO daoProfessor = new ProfessorDAO();

        try{
            double progressRevenue = daoTuition.getTuitionsRevenuePercentage();
            if (progressRevenue == 0){
                progressRevenue = 0;
            }
            double progressStudents = daoStudent.getStudentCountProgress();
            if (progressStudents == 0){
                progressStudents = 0;
            }
            double progressProfessors = daoProfessor.getProfessorProgress();
            if (progressProfessors == 0){
                progressProfessors = 0;
            }
            double progressInstitutions = daoInstitution.getInstitutionProgress();
            if (progressInstitutions == 0){
                progressInstitutions = 0;
            }
            double progressCourses = daoCourse.getCoursesProgress();
            if (progressCourses == 0){
                progressCourses = 0;
            }

            String revenueCountEuro = daoTuition.getTuitionsRevenue();
            if (revenueCountEuro.equals("")){
                revenueCountEuro = "0";
            }
            String studentCountNumb = daoStudent.getStudentCount();
            if (studentCountNumb.equals("")){
                studentCountNumb = "0";
            }
            String professorCountNumb = daoProfessor.getProfessorCount();
            if (professorCountNumb.equals("")){
                professorCountNumb = "0";
            }
            String institutionCountNumb = daoInstitution.getInstitutionCount();
            if (institutionCountNumb.equals("")){
                institutionCountNumb = "0";
            }
            String coursesCountNumb = daoCourse.getCoursesCount();
            if (coursesCountNumb.equals("")){
                coursesCountNumb = "0";
            }

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
        }catch (Exception ex){
            ex.printStackTrace();
            //bad smell here :O
        }
    }
}
