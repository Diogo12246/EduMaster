package Controller;

import Model.Course;
import Model.Professor;
import Model_DAO.CourseDAO;
import Model_DAO.ProfessorDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EduMasterProfessorController extends AnchorPane implements Initializable {

    @FXML
    private TableView<Professor> tableViewProfessor;
    @FXML
    private TableColumn<Professor, Integer> col_id;
    @FXML
    private TableColumn<Professor, String> col_professorFName;
    @FXML
    private TableColumn<Professor, String> col_professorLName;
    @FXML
    private TextField professorFName;
    @FXML
    private TextField professorLName;
    @FXML
    private Button createProfessorBtn;
    @FXML
    private Button updateProfessorBtn;
    @FXML
    private Button deleteProfessorBtn;
    @FXML
    private ComboBox<Course> CourseComboBox;
    @FXML
    private Button assignProfessorCourseBtn;
    @FXML
    private Button removeProfesorCourseBtn;
    @FXML
    private Label courseAssignRemoveLabel;
    @FXML
    private ListView<Course> professorCourseListView;

    private static int professorID;
    private ObservableList<Course> coursesList = FXCollections.observableArrayList();
    private ObservableList<Course> professorCoursesList = FXCollections.observableArrayList();

    public EduMasterProfessorController() {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/FXML/EduMasterProfessorPanel.fxml"));
            fxml.setRoot(this);
            fxml.setController(this);
            fxml.load();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void createProfessor() {
        ProfessorDAO dao = new ProfessorDAO();
        Professor professor = new Professor();
        professor.setProfessorFName(professorFName.getText());
        professor.setProfessorLName(professorLName.getText());
        dao.createProfessor(professor);
        updateData();
    }

    @FXML
    private void updateProfessor() {
        ProfessorDAO dao = new ProfessorDAO();
        Professor professor = new Professor();
        professor.setProfessorFName(professorFName.getText());
        professor.setProfessorLName(professorLName.getText());
        professor.setId(professorID);
        dao.updateProfessor(professor);
        updateData();
    }

    @FXML
    private void deleteProfessor() {
        ProfessorDAO dao = new ProfessorDAO();
        Professor professor = new Professor();
        professor.setId(professorID);
        dao.deleteProfessor(professor);
        updateData();
    }

    @FXML
    private void assignProfessorToCourse(){
        ProfessorDAO dao = new ProfessorDAO();
        Professor selectedProfessor = tableViewProfessor.getSelectionModel().getSelectedItem();
        int professorID = selectedProfessor.getId();
        int courseID = CourseComboBox.getSelectionModel().getSelectedItem().getId();
        dao.assignProfessorToCourse(professorID,courseID);
        updateData();
    }

    @FXML
    private void deleteProfessorFromCourse(){
        ProfessorDAO dao = new ProfessorDAO();
        Professor selectedProfessor = tableViewProfessor.getSelectionModel().getSelectedItem();
        int professorID = selectedProfessor.getId();
        int courseID = CourseComboBox.getSelectionModel().getSelectedItem().getId();
        dao.deleteProfessorFromCourse(professorID,courseID);
        updateData();
    }


    public void updateData() {
        ProfessorDAO dao = new ProfessorDAO();
        CourseDAO daoCourse = new CourseDAO();
        ObservableList<Professor> professors;
        professors = dao.getProfessors();
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_professorFName.setCellValueFactory(new PropertyValueFactory<>("professorFName"));
        col_professorLName.setCellValueFactory(new PropertyValueFactory<>("professorLName"));
        tableViewProfessor.setItems(professors);
        tableViewProfessor.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 1) {
                professorControl();
            }
        });
        coursesList =  daoCourse.getCourses();
        CourseComboBox.setItems(coursesList);
        CourseComboBox.getSelectionModel().selectFirst();
        professorCoursesList = dao.getProfessorCourseList(professorID);
        professorCourseListView.setItems(professorCoursesList);

    }

    public void professorControl() {
        if (tableViewProfessor.getSelectionModel().getSelectedItem() != null)
        {
            ProfessorDAO dao = new ProfessorDAO();
            CourseDAO daoCourse = new CourseDAO();
            Professor selectedProfessor = tableViewProfessor.getSelectionModel().getSelectedItem();
            professorFName.setText(selectedProfessor.getProfessorFName());
            professorLName.setText(selectedProfessor.getProfessorLName());
            professorID = selectedProfessor.getId();
            coursesList =  daoCourse.getCourses();
            professorCoursesList = dao.getProfessorCourseList(professorID);
            professorCourseListView.setItems(professorCoursesList);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateData();
    }
}
