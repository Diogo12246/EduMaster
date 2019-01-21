package Model_DAO;

import ConnectionManager.ConnectionMasterBuilder;
import Model.Institution;
import Model.Student;
import Model.Tuition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utility.EduTuitionUuidGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

    private ObservableList<Student> students = FXCollections.observableArrayList();
    private ObservableList<Institution> studentInstitutions = FXCollections.observableArrayList();

    public ObservableList<Student> getStudents() {
        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM student");
            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("studentFName"), rs.getString("studentLName"), rs.getString("studentEmail"), rs.getString("tuitionCode")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void createStudent(Student student) {
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        String uuidStudent = EduTuitionUuidGenerator.uuidTuitionGenerator();
        try {
            stmt = con.prepareStatement("INSERT INTO student (studentFName,studentLName,studentEmail,tuitionCode) values (?,?,?,?)");
            stmt.setString(1, student.getStudentFName());
            stmt.setString(2,student.getStudentLName());
            stmt.setString(3,student.getStudentEmail());
            stmt.setString(4, uuidStudent);
            stmt.executeUpdate();
            TuitionDAO daoTuition = new TuitionDAO();
            daoTuition.assignTuitionToStudent(uuidStudent);
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
        String uuidStudent = student.getTuitionCode();
        try {
            stmt = con.prepareStatement("DELETE FROM student WHERE id = ?");
            stmt.setInt(1, student.getId());
            stmt.executeUpdate();
            TuitionDAO daoTuition = new TuitionDAO();
            daoTuition.removeTuitionToStudent(uuidStudent);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public ObservableList<Institution> getStudentInstitutionList(int id){
        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT institution.id as id, institution.institutionName as institution FROM student_institution INNER JOIN institution ON student_institution.institution_id = institution.id INNER JOIN student ON student_institution.student_id = student.id WHERE student.id = " + id);
            while (rs.next()){
                studentInstitutions.add(new Institution(rs.getInt("id"),rs.getString("institution")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentInstitutions;
    }

    public void assignStudentToInstitution(int studentID,int institutionId){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO student_institution (student_id,institution_id) VALUES (?,?)");
            stmt.setInt(1, studentID);
            stmt.setInt(2, institutionId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public void deleteProfessorFromCourse(int studentID,int institutionId){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("delete from student_institution WHERE student_id = ? AND institution_id = ?");
            stmt.setInt(1, studentID);
            stmt.setInt(2, institutionId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }



    public double getStudentCountProgress() {
        Connection con = ConnectionMasterBuilder.getConnection();
        double value = 0.0;
        try {
            PreparedStatement statement =  con.prepareStatement("SELECT count(id) from student");
            ResultSet rs = statement.executeQuery();
            rs.next();
            String sum = rs.getString(1);
            double valueRaw = Double.parseDouble(sum);
            //formula//
            value = valueRaw / 10000;
            //////////
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }


    public String getStudentCount() {
        Connection con = ConnectionMasterBuilder.getConnection();
        String value = "";
        try {
            PreparedStatement statement =  con.prepareStatement("SELECT count(id) from student");
            ResultSet rs = statement.executeQuery();
            rs.next();
            String sum = rs.getString(1);
            value = sum;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }

}
