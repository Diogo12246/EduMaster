package Model_DAO;

import ConnectionManager.ConnectionMasterBuilder;
import Model.Institution;
import Model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

    ObservableList<Student> students = FXCollections.observableArrayList();

    public ObservableList<Student> getStudents() {
        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM student");
            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("studentFName"), rs.getString("studentLName"), rs.getString("studentEmail"), rs.getInt("tuition_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void createStudent(Student student) {
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO student (studentFName,studentLName,studentEmail) values (?,?,?)");
            stmt.setString(1, student.getStudentFName());
            stmt.setString(2,student.getStudentLName());
            stmt.setString(3,student.getStudentEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public void updateStudent(Student student){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE student SET studentFName = ?, studentLName = ?, studentEmail = ? WHERE id = ?");
            stmt.setString(1,student.getStudentFName());
            stmt.setString(2,student.getStudentLName());
            stmt.setString(3,student.getStudentEmail());
            stmt.setInt(4,student.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public void deleteStudent(Student student) {
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM student WHERE id = ?");
            stmt.setInt(1, student.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

}
