package Controller;

import Model.Student;
import Model_DAO.StudentDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EduMasterStudentController extends AnchorPane implements Initializable {

    @FXML
    private TableView<Student> tableViewStudent;
    @FXML
    private TableColumn<Student, Integer> col_id;
    @FXML
    private TableColumn<Student, String> col_studentFName;
    @FXML
    private TableColumn<Student, String> col_studentLName;
    @FXML
    private TableColumn<Student, String> col_studentEmail;
    @FXML
    private TextField studentFirstName;
    @FXML
    private TextField studentLastName;
    @FXML
    private TextField studentEmail;
    @FXML
    private Button createStudentBtn;
    @FXML
    private Button updateStudentBtn;
    @FXML
    private Button deleteStudentBtn;


    private static int studentID;

    public EduMasterStudentController() {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/FXML/EduMasterStudentPanel.fxml"));
            fxml.setRoot(this);
            fxml.setController(this);
            fxml.load();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void createStudent() {
        StudentDAO dao = new StudentDAO();
        Student student = new Student();
        student.setStudentFName(studentFirstName.getText());
        student.setStudentLName(studentLastName.getText());
        student.setStudentEmail(studentEmail.getText());
        dao.createStudent(student);
        updateData();
    }

    @FXML
    private void updateStudent() {
        StudentDAO dao = new StudentDAO();
        Student student = new Student();
        student.setStudentFName(studentFirstName.getText());
        student.setStudentLName(studentLastName.getText());
        student.setStudentEmail(studentEmail.getText());
        student.setId(studentID);
        dao.updateStudent(student);
        updateData();
    }


    @FXML
    private void deleteStudent() {
        StudentDAO dao = new StudentDAO();
        Student student = new Student();
        student.setId(studentID);
        dao.deleteStudent(student);
        updateData();
    }


    public void updateData() {
        StudentDAO dao = new StudentDAO();
        ObservableList<Student> students;
        students = dao.getStudents();

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_studentFName.setCellValueFactory(new PropertyValueFactory<>("studentFName"));
        col_studentLName.setCellValueFactory(new PropertyValueFactory<>("studentLName"));
        col_studentEmail.setCellValueFactory(new PropertyValueFactory<>("studentEmail"));
        tableViewStudent.setItems(students);
        tableViewStudent.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 1) {
                studentControl();
            }
        });
    }

    public void studentControl() {
        if (tableViewStudent.getSelectionModel().getSelectedItem() != null) {
            Student selectedStudent = tableViewStudent.getSelectionModel().getSelectedItem();
            studentFirstName.setText(selectedStudent.getStudentFName());
            studentLastName.setText(selectedStudent.getStudentLName());
            studentEmail.setText(selectedStudent.getStudentEmail());
            studentID = selectedStudent.getId();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateData();
    }
}
