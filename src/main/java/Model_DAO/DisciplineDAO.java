package Model_DAO;

import ConnectionManager.ConnectionMasterBuilder;
import Model.Course;
import Model.Discipline;
import Model.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sun.plugin.com.DispatchImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisciplineDAO {


/*
THIS IS THE DAO FOR SAID OBJECT.
YOU CAN FIND ALL METHODS OF ACCESS LAYER HERE
*/

    private ObservableList<Discipline> disciplines = FXCollections.observableArrayList();
    private ObservableList<Professor> disciplineProfessors = FXCollections.observableArrayList();
    private ObservableList<Course> disciplineCourse = FXCollections.observableArrayList();

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

    public void assignDisciplineToProfessor(int professorID, int disciplineId){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO professor_discipline (professor_id,discipline_id) VALUES (?,?)");
            stmt.setInt(1, professorID);
            stmt.setInt(2, disciplineId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public void deleteDisciplineFromProfessor(Integer professorID,Integer disciplineId){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("delete from professor_discipline WHERE professor_id = ? AND discipline_id = ?");
            stmt.setInt(1, professorID);
            stmt.setInt(2, disciplineId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public ObservableList<Professor> getProfessorDisciplineList(Integer id){
        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT professor_id as id,professor.professorFName as professorFName, professorLName as professorLName FROM professor_discipline INNER JOIN professor ON professor_discipline.professor_id = professor.id INNER JOIN discipline ON professor_discipline.discipline_id = discipline.id WHERE discipline.id = " + id);
            while (rs.next()){
                disciplineProfessors.add(new Professor(rs.getInt("id"),rs.getString("professorFName"),rs.getString("professorLName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplineProfessors;
    }

    public ObservableList<Course> getDisciplineCourseList(Integer id){
        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT course_id as id,course.courseName as Course FROM course_discipline INNER JOIN course ON course_discipline.course_id = course.id INNER JOIN discipline ON course_discipline.discipline_id = discipline.id WHERE discipline.id = " + id);
            while (rs.next()){
                disciplineCourse.add(new Course(rs.getInt("id"),rs.getString("Course")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplineCourse;
    }


    public void assignDisciplineToCourse(int courseID, int disciplineId){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO course_discipline (course_id,discipline_id) VALUES (?,?)");
            stmt.setInt(1, courseID);
            stmt.setInt(2, disciplineId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public void deleteDisciplineFromCourse(int courseID,int disciplineId){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("delete from course_discipline WHERE course_id = ? AND discipline_id = ?");
            stmt.setInt(1, courseID);
            stmt.setInt(2, disciplineId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }
}
