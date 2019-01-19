package Controller;

import Model.Course;
import Model.Discipline;
import Model.Professor;
import Model_DAO.CourseDAO;
import Model_DAO.DisciplineDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EduMasterCourseController extends AnchorPane implements Initializable {

    @FXML
    private AnchorPane content;
    @FXML
    private TableView<Course> tableViewCourses;
    @FXML
    private TableColumn<Course, Integer> col_id;
    @FXML
    private TableColumn<Course, String> col_courseName;
    @FXML
    private TableColumn<Course, String> col_courseDescription;
    @FXML
    private TextField courseName;
    @FXML
    private TextArea courseDescription;
    @FXML
    private Button insertCourseBtn;
    @FXML
    private Button updateCourseBtn;
    @FXML
    private Button deleteCourseBtn;
    @FXML
    private ImageView courseImage;
    @FXML
    private ListView<Discipline> discipline_courseList;
    @FXML
    private ComboBox<Professor> ProfessorComboBox;

    private ObservableList<Discipline> disciplinesList = FXCollections.observableArrayList();
    private static int courseID;

    public EduMasterCourseController() {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/FXML/EduMasterCoursePanel.fxml"));
            fxml.setRoot(this);
            fxml.setController(this);
            fxml.load();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void updateCourse() {
        CourseDAO dao = new CourseDAO();
        Course course = new Course();
        course.setCourseName(courseName.getText());
        course.setCourseDescription(courseDescription.getText());
        course.setId(courseID);
        dao.updateCourse(course);
        updateData();
    }

    @FXML
    private void createCourse() {
        CourseDAO dao = new CourseDAO();
        Course course = new Course();
        course.setCourseName(courseName.getText());
        course.setCourseDescription(courseDescription.getText());
        dao.createCourse(course);
        updateData();
    }

    @FXML
    private void deleteCourse() {
        CourseDAO dao = new CourseDAO();
        Course course = new Course();
        course.setId(courseID);
        dao.deleteCourse(course);
        updateData();
    }


    public void updateData() {
        CourseDAO dao = new CourseDAO();
        ObservableList<Course> courses;
        courses = dao.getCourses();

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_courseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        col_courseDescription.setCellValueFactory(new PropertyValueFactory<>("courseDescription"));
        tableViewCourses.setItems(courses);
        tableViewCourses.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 1) {
                courseControl();
            }
        });

    }

    public void courseControl() {
        if (tableViewCourses.getSelectionModel().getSelectedItem() != null) {
            Course selectedCourse = tableViewCourses.getSelectionModel().getSelectedItem();
            courseName.setText(selectedCourse.getCourseName());
            courseDescription.setText(selectedCourse.getCourseDescription());
            courseID = selectedCourse.getId();
            DisciplineDAO dao = new DisciplineDAO();
            disciplinesList = dao.getCourseDiscipline(courseID);
            discipline_courseList.setItems(disciplinesList);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateData();
    }
}

