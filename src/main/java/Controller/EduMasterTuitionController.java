package Controller;

import Model.Student;
import Model.Tuition;
import Model_DAO.TuitionDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EduMasterTuitionController extends AnchorPane implements Initializable {

    private int tuitionID;

    @FXML
    private TableView<Tuition> tuitionTableView;
    @FXML
    private TableColumn<Tuition, Integer> col_id;
    @FXML
    private TableColumn<Tuition, String> col_code;
    @FXML
    private TableColumn<Tuition, Integer> col_value;
    @FXML
    private TableColumn<Tuition, Boolean> col_paid;
    @FXML
    private Button makeTuitionPaid;
    @FXML
    private Button makeTuitionUnpaid;
    @FXML
    private ListView<Student> studentTuitionListView;

    private ObservableList<Student> studentTuitionList = FXCollections.observableArrayList();

    public EduMasterTuitionController() {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/FXML/EduMasterTuitionPanel.fxml"));
            fxml.setRoot(this);
            fxml.setController(this);
            fxml.load();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void makeTuitionPaid(){
        TuitionDAO dao = new TuitionDAO();
        tuitionID = tuitionTableView.getSelectionModel().getSelectedItem().getId();
        dao.updateTuitionPaid(tuitionID);
        updateData();
    }

    public void makeTuitionUnpaid(){
        TuitionDAO dao = new TuitionDAO();
        tuitionID = tuitionTableView.getSelectionModel().getSelectedItem().getId();
        dao.updateTuitionUnpaid(tuitionID);
        updateData();
    }

    public void updateData() {
        TuitionDAO dao = new TuitionDAO();
        ObservableList<Tuition> tuitions;
        tuitions = dao.getTuitions();
        String tuitionCode;

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_code.setCellValueFactory(new PropertyValueFactory<>("tuitionCode"));
        col_value.setCellValueFactory(new PropertyValueFactory<>("tuitionValue"));
        col_paid.setCellValueFactory(new PropertyValueFactory<>("tuitionPaid"));
        tuitionTableView.setItems(tuitions);
        tuitionTableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 1) {
                tuitionControl();
            }
        });
        if (tuitionTableView.getSelectionModel().getSelectedItem() == null){
            //System.out.println("null value");
        }
        else{
            tuitionCode = tuitionTableView.getSelectionModel().getSelectedItem().getTuitionCode();
            studentTuitionList = dao.getStudentTuitionList(tuitionCode);
            studentTuitionListView.setItems(studentTuitionList);
        }

    }

    public void tuitionControl() {
        if (tuitionTableView.getSelectionModel().getSelectedItem() != null) {
            TuitionDAO daoTuition = new TuitionDAO();
            Tuition selectedTuition = tuitionTableView.getSelectionModel().getSelectedItem();
            tuitionID = selectedTuition.getId();

            String tuitionCode = tuitionTableView.getSelectionModel().getSelectedItem().getTuitionCode();
            studentTuitionList = daoTuition.getStudentTuitionList(tuitionCode);
            studentTuitionListView.setItems(studentTuitionList);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateData();
    }
}
