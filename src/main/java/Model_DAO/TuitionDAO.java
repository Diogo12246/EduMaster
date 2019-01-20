package Model_DAO;

import ConnectionManager.ConnectionMasterBuilder;
import Model.Student;
import Model.Tuition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TuitionDAO {

    private ObservableList<Tuition> tuitions = FXCollections.observableArrayList();
    private ObservableList<Student> studentList = FXCollections.observableArrayList();

    public ObservableList<Tuition> getTuitions() {
        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM tuition");
            while (rs.next()){
                tuitions.add(new Tuition(rs.getInt("id"),rs.getString("tuitionCode"),rs.getInt("tuitionValue"),rs.getBoolean("tuitionPaid")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tuitions;
    }


    public ObservableList<Student> getStudentTuitionList(String code){
/*
        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("Select student.studentFName as FirstName, student.studentLName as LastName, student.studentEmail as Email, student.tuitionCode as tCode from student where student.tuitionCode = " + code);
            while (rs.next()){
                studentList.add(new Student(rs.getString("FirstName"),rs.getString("LastName"),rs.getString("Email"),rs.getString("tCode")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
        */
        return null;
    }

    public void updateTuitionPaid(int tuitionID){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tuition SET tuitionPaid = ? WHERE tuition.id = ?");
            stmt.setInt(1, 1);
            stmt.setInt(2, tuitionID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public void updateTuitionUnpaid(int tuitionID){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tuition SET tuitionPaid = ? WHERE tuition.id = ?");
            stmt.setInt(1, 0);
            stmt.setInt(2, tuitionID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public void assignTuitionToStudent(String tuitionCode){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tuition (tuitionCode,tuitionValue,tuitionPaid) VALUES (?,?,?)");
            stmt.setString(1, tuitionCode);
            stmt.setInt(2, 1500);
            stmt.setInt(3,0);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }
}
