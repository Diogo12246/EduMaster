package Model_DAO;

import ConnectionManager.ConnectionMasterBuilder;
import Model.Discipline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sun.plugin.com.DispatchImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public ObservableList<Discipline> getDisciplines(){
        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM discipline");
            while (rs.next()){
                disciplines.add(new Discipline(rs.getInt("id"),rs.getString("disciplineName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplines;
    }


    public void updateDiscipline(Discipline discipline){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE discipline SET disciplineName = ? WHERE id = ?");
            stmt.setString(1,discipline.getDisciplineName());
            stmt.setInt(2, discipline.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }

    }

    public void createDiscipline(Discipline discipline){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO discipline (disciplineName) VALUES(?)");
            stmt.setString(1, discipline.getDisciplineName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }

    }

    public void deleteDiscipline(Discipline discipline){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM discipline where id = ?");
            stmt.setInt(1, discipline.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }

    }







}
