package pt.diogo12246.Model_DAO;

import pt.diogo12246.ConnectionManager.ConnectionMasterBuilder;
import pt.diogo12246.Model.Student;
import pt.diogo12246.Model.Tuition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TuitionDAO {


/*
THIS IS THE DAO FOR SAID OBJECT.
YOU CAN FIND ALL METHODS OF ACCESS LAYER HERE
*/

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

        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("Select student.studentFName as FirstName, student.studentLName as LastName,student.studentEmail as Email,student.tuitionCode from student where student.tuitionCode =" + "\"" + code + "\"");

            while (rs.next()){
                studentList.add(new Student(rs.getString("FirstName"),rs.getString("LastName"),rs.getString("Email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
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

    public void removeTuitionToStudent(String tuitionCode){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tuition where tuitionCode = ?");
            stmt.setString(1, tuitionCode);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public double getTuitionsRevenuePercentage() {
        Connection con = ConnectionMasterBuilder.getConnection();
        double value=0.0;
        try {
            PreparedStatement statement =  con.prepareStatement("SELECT sum(tuitionValue) FROM tuition");
            ResultSet rs = statement.executeQuery();
            rs.next();
            String sum = rs.getString(1);
            double valueRaw = Double.parseDouble(sum);
            //formula//
            value = valueRaw / 100000;
            //////////
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }

    public String getTuitionsRevenue() {
        Connection con = ConnectionMasterBuilder.getConnection();
        String value = "";
        try {
            PreparedStatement statement =  con.prepareStatement("SELECT sum(tuitionValue) FROM tuition");
            ResultSet rs = statement.executeQuery();
            rs.next();
            String sum = rs.getString(1);
            if (sum.equals("")){
                value = "0";
            }
            else {
                value = sum;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }
}
