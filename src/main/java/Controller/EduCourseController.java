package Controller;

import Model.Course;
import Model_DAO.CourseDAO;
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

public class EduCourseController extends AnchorPane implements Initializable {


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
    private Button insertCourse;
    @FXML
    private Button updateCourse;

    private ObservableList<Course> courseList = FXCollections.observableArrayList();
    private static int courseID;

    public EduCourseController() {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/FXML/CoursePanel.fxml"));
            fxml.setRoot(this);
            fxml.setController(this);
            fxml.load();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void updateCourse(){
        CourseDAO dao = new CourseDAO();
        Course course = new Course();
        course.setCourseName(courseName.getText());
        course.setCourseDescription(courseDescription.getText());
        course.setId(courseID);
        dao.updateCourse(course);
        updateData();
    }

    @FXML
    public void createCourse(){
        CourseDAO dao = new CourseDAO();
        Course course = new Course();
        course.setCourseName(courseName.getText());
        course.setCourseDescription(courseDescription.getText());
        dao.createCourse(course);
        updateData();
    }

    public void updateData(){
        CourseDAO dao = new CourseDAO();
        ObservableList<Course> courses;
        courses = dao.getCourses();

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_courseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        col_courseDescription.setCellValueFactory(new PropertyValueFactory<>("courseDescription"));

        tableViewCourses.setItems(courses);
        tableViewCourses.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1) {
                courseControl();
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateData();
    }

    public void courseControl(){
        if (tableViewCourses.getSelectionModel().getSelectedItem() != null){
            Course selectedCourse = tableViewCourses.getSelectionModel().getSelectedItem();
            courseName.setText(selectedCourse.getCourseName());
            courseDescription.setText(selectedCourse.getCourseDescription());
            courseID = selectedCourse.getId();
        }
    }

}

