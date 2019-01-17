package Model_DAO;

import ConnectionManager.ConnectionMasterBuilder;
import Model.Institution;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InstitutionDAO {

    private ObservableList<Institution> institutions = FXCollections.observableArrayList();

    public ObservableList<Institution> getInstitutions() {
        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM institution");
            while (rs.next()) {
                institutions.add(new Institution(rs.getInt("id"), rs.getString("institutionName"), rs.getString("InstitutionStamp"), rs.getString("institutionCity"), rs.getInt("institutionSales")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return institutions;
    }

    public void createInstitution(Institution institution) {
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            System.out.println(institution.getInstitutionName() + " " + institution.getId());
            stmt = con.prepareStatement("INSERT INTO institution (institution.institutionName,institution.institutionStamp,institution.institutionCity,institution.institutionSales) VALUES(?,?,?,?)");
            stmt.setString(1, institution.getInstitutionName());
            stmt.setString(2, institution.getInstitutionStamp());
            stmt.setString(3, institution.getInstitutionCity());
            stmt.setInt(4, institution.getInstitutionSales());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public void deleteInstitution(Institution institution) {
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            System.out.println(institution.getInstitutionName() + " " + institution.getId());
            stmt = con.prepareStatement("DELETE FROM institution where id = ?");
            stmt.setInt(1, institution.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public void updateInstitution(Institution institution){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE institution SET institutionName = ?, institutionStamp = ?, institutionCity = ? WHERE id = ?");
            stmt.setString(1, institution.getInstitutionName());
            stmt.setString(2, institution.getInstitutionStamp());
            stmt.setString(3, institution.getInstitutionCity());
            stmt.setInt(4, institution.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }


}
