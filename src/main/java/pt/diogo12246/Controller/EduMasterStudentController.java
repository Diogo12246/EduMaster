package pt.diogo12246.Controller;

import pt.diogo12246.Model.Institution;
import pt.diogo12246.Model.Student;
import pt.diogo12246.Model_DAO.InstitutionDAO;
import pt.diogo12246.Model_DAO.StudentDAO;
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
    private TableColumn<Student, String> col_studentTuitionID;
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
    @FXML
    private ListView<Institution> studentInstitutionListView;
    @FXML
    private ComboBox<Institution> institutionComboBox;
    @FXML
    private Button assignStudentToInstitutionsBtn;
    @FXML
    private Button removeStudentFromInstitutionsBtn;


    private static int studentID;
    private static String studentTID;
    private ObservableList<Institution> institutionsList = FXCollections.observableArrayList();
    private ObservableList<Institution> studentInstitutionList = FXCollections.observableArrayList();


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
        student.setTuitionCode(studentTID);
        dao.deleteStudent(student);
        updateData();
    }

    @FXML
    private void assignStudentToInstitution(){
        StudentDAO dao = new StudentDAO();
        Student selectedStudent = tableViewStudent.getSelectionModel().getSelectedItem();
        int studentID = selectedStudent.getId();
        int institutionID = institutionComboBox.getSelectionModel().getSelectedItem().getId();
        dao.assignStudentToInstitution(studentID,institutionID);
        updateData();
    }

    @FXML
    private void deleteStudentFromInstitution(){
        StudentDAO dao = new StudentDAO();
        Student selectedStudent = tableViewStudent.getSelectionModel().getSelectedItem();
        int studentID = selectedStudent.getId();
        int institutionID = institutionComboBox.getSelectionModel().getSelectedItem().getId();
        dao.deleteProfessorFromCourse(studentID,institutionID);
        updateData();
    }



    private void updateData() {
        StudentDAO dao = new StudentDAO();
        ObservableList<Student> students;
        students = dao.getStudents();

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_studentFName.setCellValueFactory(new PropertyValueFactory<>("studentFName"));
        col_studentLName.setCellValueFactory(new PropertyValueFactory<>("studentLName"));
        col_studentEmail.setCellValueFactory(new PropertyValueFactory<>("studentEmail"));
        col_studentTuitionID.setCellValueFactory(new PropertyValueFactory<>("tuitionCode"));
        tableViewStudent.setItems(students);
        tableViewStudent.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 1) {
                studentControl();
            }
        });

        InstitutionDAO daoInstitution = new InstitutionDAO();
        institutionsList = daoInstitution.getInstitutions();
        institutionComboBox.setItems(institutionsList);
        institutionComboBox.getSelectionModel().selectFirst();

        studentInstitutionList = dao.getStudentInstitutionList(studentID);
        studentInstitutionListView.setItems(studentInstitutionList);

    }

    private void studentControl() {
        if (tableViewStudent.getSelectionModel().getSelectedItem() != null) {
            Student selectedStudent = tableViewStudent.getSelectionModel().getSelectedItem();
            studentFirstName.setText(selectedStudent.getStudentFName());
            studentLastName.setText(selectedStudent.getStudentLName());
            studentEmail.setText(selectedStudent.getStudentEmail());
            studentID = selectedStudent.getId();
            studentTID = selectedStudent.getTuitionCode();

            InstitutionDAO daoInstitution = new InstitutionDAO();
            institutionsList = daoInstitution.getInstitutions();
            institutionComboBox.setItems(institutionsList);
            institutionComboBox.getSelectionModel().selectFirst();

            StudentDAO dao = new StudentDAO();
            studentInstitutionList = dao.getStudentInstitutionList(studentID);
            studentInstitutionListView.setItems(studentInstitutionList);

        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateData();
    }
}
