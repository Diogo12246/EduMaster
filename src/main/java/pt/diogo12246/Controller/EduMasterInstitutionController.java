package pt.diogo12246.Controller;

import pt.diogo12246.Model.Course;
import pt.diogo12246.Model.Institution;
import pt.diogo12246.Model_DAO.InstitutionDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EduMasterInstitutionController extends AnchorPane implements Initializable {

    @FXML
    private TableView<Institution> tableViewInstitution;
    @FXML
    private TableColumn<Institution, Integer> col_id;
    @FXML
    private TableColumn<Institution, String> col_institutionName;
    @FXML
    private TableColumn<Institution, String> col_institutionStamp;
    @FXML
    private TableColumn<Institution, String> col_institutionCity;
    @FXML
    private TextField institutionName;
    @FXML
    private TextField institutionStamp;
    @FXML
    private TextField institutionCity;
    @FXML
    private ListView<Course> institutionCoursesListView;

    private static int institutionID;
    private ObservableList<Course> institutionCoursesList = FXCollections.observableArrayList();

    public EduMasterInstitutionController() {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/FXML/EduMasterInstitutionPanel.fxml"));
            fxml.setRoot(this);
            fxml.setController(this);
            fxml.load();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void createInstitution() {
        InstitutionDAO dao = new InstitutionDAO();
        Institution institution = new Institution();
        institution.setInstitutionName(institutionName.getText());
        institution.setInstitutionStamp(institutionStamp.getText());
        institution.setInstitutionCity(institutionCity.getText());
        institution.setInstitutionSales(0);
        dao.createInstitution(institution);
        updateData();
    }

    @FXML
    private void updateInstitution() {
        InstitutionDAO dao = new InstitutionDAO();
        Institution institution = new Institution();
        institution.setInstitutionName(institutionName.getText());
        institution.setInstitutionStamp(institutionStamp.getText());
        institution.setInstitutionCity(institutionCity.getText());
        institution.setId(institutionID);
        dao.updateInstitution(institution);
        updateData();
    }

    @FXML
    private void deleteInstitution() {
        InstitutionDAO dao = new InstitutionDAO();
        Institution institution = new Institution();
        institution.setId(institutionID);
        dao.deleteInstitution(institution);
        updateData();
    }


    public void updateData() {
        InstitutionDAO dao = new InstitutionDAO();
        ObservableList<Institution> institutions;
        institutions = dao.getInstitutions();

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_institutionName.setCellValueFactory(new PropertyValueFactory<>("institutionName"));
        col_institutionStamp.setCellValueFactory(new PropertyValueFactory<>("institutionStamp"));
        col_institutionCity.setCellValueFactory(new PropertyValueFactory<>("institutionCity"));
        tableViewInstitution.setItems(institutions);
        tableViewInstitution.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 1) {
                institutionControl();
            }
        });

        institutionCoursesList = dao.getInstitutionsCourses(institutionID);
        institutionCoursesListView.setItems(institutionCoursesList);

    }

    public void institutionControl() {
        if (tableViewInstitution.getSelectionModel().getSelectedItem() != null) {
            InstitutionDAO dao = new InstitutionDAO();
            Institution selectedInstitution = tableViewInstitution.getSelectionModel().getSelectedItem();
            institutionName.setText(selectedInstitution.getInstitutionName());
            institutionStamp.setText(selectedInstitution.getInstitutionStamp());
            institutionCity.setText(selectedInstitution.getInstitutionCity());
            institutionID = selectedInstitution.getId();
            institutionCoursesList = dao.getInstitutionsCourses(institutionID);
            institutionCoursesListView.setItems(institutionCoursesList);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateData();
    }
}
