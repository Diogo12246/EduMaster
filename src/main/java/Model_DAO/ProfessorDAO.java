package Model_DAO;

import ConnectionManager.ConnectionMasterBuilder;
import Model.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDAO {

    private ObservableList<Professor> professors = FXCollections.observableArrayList();

    public ObservableList<Professor> getProfessors(){
        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM professor");
            while (rs.next()){
                professors.add(new Professor(rs.getInt("id"),rs.getString("professorFName"),rs.getString("professorLName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professors;
    }


    public void updateProfessor(Professor professor){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE professor SET professorFName = ?, professorLName = ?, WHERE id = ?");
            stmt.setString(1,professor.getProfessorFName());
            stmt.setString(2,professor.getProfessorLName());
            stmt.setInt(3, professor.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }

    }

    public void createProfessor(Professor professor){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO professor (professorFName,professorLName) VALUES(?,?)");
            stmt.setString(1, professor.getProfessorFName());
            stmt.setString(2,professor.getProfessorLName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }

    }

    public void deleteProfessor(Professor professor){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM professor where id = ?");
            stmt.setInt(1, professor.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }

    }

}
