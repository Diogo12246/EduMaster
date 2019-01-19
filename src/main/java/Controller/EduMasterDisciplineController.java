package Controller;

import Model.Course;
import Model.Discipline;
import Model.Professor;
import Model_DAO.CourseDAO;
import Model_DAO.DisciplineDAO;
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

public class EduMasterDisciplineController extends AnchorPane implements Initializable {

    @FXML
    private TableView<Discipline> tableViewDisciplines;
    @FXML
    private TableColumn<Discipline, Integer> col_id;
    @FXML
    private TableColumn<Discipline, String> col_disciplineName;
    @FXML
    private TextField disciplineName;
    @FXML
    private Button createDisciplineBtn;
    @FXML
    private Button updateDisciplineBtn;
    @FXML
    private Button deleteDisciplineBtn;
    @FXML
    private ListView<Discipline> discipline_courseList;
    @FXML
    private ComboBox<Professor> professorComboBox;
    @FXML
    private Button assignDisciplineToProfessorBtn;
    @FXML
    private Button removeDisciplineFromProfessorBtn;
    @FXML
    private ListView<Professor> professorDisciplineListView;
    @FXML
    private ComboBox<Course> courseComboBox;
    @FXML
    private Button assignCourseToDisciplineBtn;
    @FXML
    private Button removeCourseFromDisciplineBtn;
    @FXML
    private ListView<Course> courseDisciplineListView;

    private ObservableList<Professor> professorList = FXCollections.observableArrayList();
    private ObservableList<Course> courseList = FXCollections.observableArrayList();
    private ObservableList<Professor> professorDisciplineList = FXCollections.observableArrayList();
    private ObservableList<Course> disciplineCourseList = FXCollections.observableArrayList();
    private static int disciplineID;

    public EduMasterDisciplineController() {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/FXML/EduMasterDisciplinePanel.fxml"));
            fxml.setRoot(this);
            fxml.setController(this);
            fxml.load();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void createDiscipline() {
        DisciplineDAO dao = new DisciplineDAO();
        Discipline discipline = new Discipline();
        discipline.setDisciplineName(disciplineName.getText());
        dao.createDiscipline(discipline);
        updateData();
    }

    @FXML
    private void updateDiscipline() {
        DisciplineDAO dao = new DisciplineDAO();
        Discipline discipline = new Discipline();
        discipline.setDisciplineName(disciplineName.getText());
        discipline.setId(disciplineID);
        dao.updateDiscipline(discipline);
        updateData();
    }

    @FXML
    private void deleteDiscipline() {
        DisciplineDAO dao = new DisciplineDAO();
        Discipline discipline = new Discipline();
        discipline.setId(disciplineID);
        dao.deleteDiscipline(discipline);
        updateData();
    }

    @FXML
    private void assignDisciplineToProfessor(){
        DisciplineDAO dao = new DisciplineDAO();
        Discipline discipline = tableViewDisciplines.getSelectionModel().getSelectedItem();
        disciplineID = discipline.getId();
        int professorID = professorComboBox.getSelectionModel().getSelectedItem().getId();
        dao.assignDisciplineToProfessor(professorID,disciplineID);
        updateData();
    }

    @FXML
    private void deleteDisciplineFromProfessor(){
        DisciplineDAO dao = new DisciplineDAO();
        Discipline discipline = tableViewDisciplines.getSelectionModel().getSelectedItem();
        disciplineID = discipline.getId();
        int professorID = professorComboBox.getSelectionModel().getSelectedItem().getId();
        dao.deleteDisciplineFromProfessor(professorID,disciplineID);
        updateData();
    }

    @FXML
    private void assignDisciplineToCourse(){
        DisciplineDAO dao = new DisciplineDAO();
        Discipline discipline = tableViewDisciplines.getSelectionModel().getSelectedItem();
        disciplineID = discipline.getId();
        int courseID = courseComboBox.getSelectionModel().getSelectedItem().getId();
        dao.assignDisciplineToCourse(courseID,disciplineID);
        updateData();
    }

    @FXML
    private void deleteDisciplineFromCourse(){
        DisciplineDAO dao = new DisciplineDAO();
        Discipline discipline = tableViewDisciplines.getSelectionModel().getSelectedItem();
        disciplineID = discipline.getId();
        int courseID = courseComboBox.getSelectionModel().getSelectedItem().getId();
        dao.deleteDisciplineFromCourse(courseID,disciplineID);
        updateData();
    }



    public void updateData() {
        DisciplineDAO dao = new DisciplineDAO();
        ProfessorDAO daoProf = new ProfessorDAO();
        CourseDAO daoCourse = new CourseDAO();
        ObservableList<Discipline> disciplines;
        disciplines = dao.getDisciplines();

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_disciplineName.setCellValueFactory(new PropertyValueFactory<>("disciplineName"));
        tableViewDisciplines.setItems(disciplines);
        tableViewDisciplines.getSelectionModel().selectFirst();
        tableViewDisciplines.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 1) {
                disciplineControl();
            }
        });

        professorList = daoProf.getProfessors();
        professorComboBox.setItems(professorList);
        professorComboBox.getSelectionModel().selectFirst();

        courseList = daoCourse.getCourses();
        courseComboBox.setItems(courseList);
        courseComboBox.getSelectionModel().selectFirst();

        professorDisciplineList = dao.getProfessorDisciplineList(disciplineID);
        professorDisciplineListView.setItems(professorDisciplineList);

        disciplineCourseList = dao.getDisciplineCourseList(disciplineID);
        courseDisciplineListView.setItems(disciplineCourseList);
        courseDisciplineListView.getSelectionModel().selectFirst();

    }

    public void disciplineControl() {
        if (tableViewDisciplines.getSelectionModel().getSelectedItem() != null) {
            Discipline selectedDiscipline = tableViewDisciplines.getSelectionModel().getSelectedItem();
            disciplineName.setText(selectedDiscipline.getDisciplineName());
            disciplineID = selectedDiscipline.getId();
            DisciplineDAO dao = new DisciplineDAO();

            ProfessorDAO daoProf = new ProfessorDAO();
            professorList = daoProf.getProfessors();
            professorComboBox.setItems(professorList);
            professorComboBox.getSelectionModel().selectFirst();

            CourseDAO daoCourse = new CourseDAO();
            courseList = daoCourse.getCourses();
            courseComboBox.setItems(courseList);
            courseComboBox.getSelectionModel().selectFirst();

            professorDisciplineList = dao.getProfessorDisciplineList(disciplineID);
            professorDisciplineListView.setItems(professorDisciplineList);

            disciplineCourseList = dao.getDisciplineCourseList(disciplineID);
            courseDisciplineListView.setItems(disciplineCourseList);
            courseDisciplineListView.getSelectionModel().selectFirst();

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateData();
    }
}
