package Controller;

import Model.Course;
import Model_DAO.CourseDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    private ObservableList<Course> courseList = FXCollections.observableArrayList();


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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CourseDAO dao = new CourseDAO();
        ObservableList<Course> courses;
        courses = dao.getCourses();


        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_courseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        col_courseDescription.setCellValueFactory(new PropertyValueFactory<>("courseDescription"));

        tableViewCourses.setItems(courses);

    }
}

