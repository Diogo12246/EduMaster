package Model_DAO;

import ConnectionManager.ConnectionMasterBuilder;
import Model.Course;
import Model.Institution;
import Model.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDAO {

    private ObservableList<Professor> professors = FXCollections.observableArrayList();
    private ObservableList<Course> professorCourseList = FXCollections.observableArrayList();
    private ObservableList<Institution> professorInstitutionList = FXCollections.observableArrayList();

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

    public void assignProfessorToCourse(Integer professorID,Integer courseId){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO professor_course (professor_id,course_id) VALUES (?,?)");
            stmt.setInt(1, professorID);
            stmt.setInt(2,courseId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public void assignProfessorToInstitution(Integer professorID,Integer institutionId){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO professor_institution (professor_id,institution_id) VALUES (?,?)");
            stmt.setInt(1, professorID);
            stmt.setInt(2, institutionId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public void deleteProfessorFromCourse(Integer professorID,Integer courseId){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("delete from professor_course WHERE professor_id = ? AND course_id = ?");
            stmt.setInt(1, professorID);
            stmt.setInt(2,courseId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public void deleteProfessorFromInstitution(Integer professorID,Integer institutionId){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("delete from professor_institution WHERE professor_id = ? AND institution_id = ?");
            stmt.setInt(1, professorID);
            stmt.setInt(2, institutionId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public ObservableList<Course> getProfessorCourseList(Integer professorId){
        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT course.id as ID, course.courseName as Course FROM professor_course INNER JOIN professor ON professor_course.professor_id = professor.id INNER JOIN course ON professor_course.course_id = course.id WHERE professor.id =" + professorId);
            while (rs.next()){
                professorCourseList.add(new Course(rs.getInt("id"),rs.getString("Course")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professorCourseList;
    }

    public ObservableList<Institution> getProfessorInstitutionList(Integer professorID) {
        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT  institution.id as id, institutionName as Institution FROM professor_institution INNER JOIN professor ON professor_institution.professor_id = professor.id INNER JOIN institution ON professor_institution.institution_id = institution.id WHERE professor.id =" + professorID);
            while (rs.next()){
                professorInstitutionList.add(new Institution(rs.getInt("id"),rs.getString("Institution")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professorInstitutionList;
    }
}
