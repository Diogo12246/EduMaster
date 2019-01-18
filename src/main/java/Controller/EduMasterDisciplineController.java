package Controller;

import Model.Discipline;
import Model_DAO.DisciplineDAO;
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


    public void updateData() {
        DisciplineDAO dao = new DisciplineDAO();
        ObservableList<Discipline> disciplines;
        disciplines = dao.getDisciplines();

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_disciplineName.setCellValueFactory(new PropertyValueFactory<>("disciplineName"));
        tableViewDisciplines.setItems(disciplines);
        tableViewDisciplines.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 1) {
                disciplineControl();
            }
        });
    }

    public void disciplineControl() {
        if (tableViewDisciplines.getSelectionModel().getSelectedItem() != null) {
            Discipline selectedDiscipline = tableViewDisciplines.getSelectionModel().getSelectedItem();
            disciplineName.setText(selectedDiscipline.getDisciplineName());
            disciplineID = selectedDiscipline.getId();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateData();
    }
}
