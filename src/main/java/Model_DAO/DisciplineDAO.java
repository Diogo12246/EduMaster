package Model_DAO;

import ConnectionManager.ConnectionMasterBuilder;
import Model.Discipline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisciplineDAO {

    private ObservableList<Discipline> disciplines = FXCollections.observableArrayList();

    public ObservableList<Discipline> getCourseDiscipline(Integer id){
        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT discipline.id as id, discipline.disciplineName as discipline FROM course_discipline INNER JOIN course ON course_discipline.course_id = course.id INNER JOIN discipline ON course_discipline.discipline_id = discipline.id WHERE course.id = " + id);
            while (rs.next()){
                disciplines.add(new Discipline(rs.getInt("id"),rs.getString("discipline")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplines;
    }




}
