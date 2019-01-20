package Model_DAO;

import ConnectionManager.ConnectionMasterBuilder;
import Model.Course;
import Model.Discipline;
import Model.Institution;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CourseDAO {

    private ObservableList<Course> courses = FXCollections.observableArrayList();
    private ObservableList<Institution> coursesInstitutions = FXCollections.observableArrayList();

    public ObservableList<Course> getCourses() {
        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM COURSE");
            while (rs.next()){
                courses.add(new Course(rs.getInt("id"),
                                rs.getString("courseName"),
                        rs.getString("courseDescription")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public ObservableList<Institution> getCourseInstitutions(int id){
        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT institution.id as id, institution.institutionName as institution FROM institution_course INNER JOIN institution ON institution_course.institution_id = institution.id INNER JOIN course ON institution_course.course_id = course.id WHERE course.id = " + id);
            while (rs.next()){
                coursesInstitutions.add(new Institution(rs.getInt("id"),rs.getString("institution")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coursesInstitutions;
    }


    public void updateCourse(Course course){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE course SET courseName = ?, courseDescription = ? WHERE id = ?");
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getCourseDescription());
            stmt.setInt(3, course.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }

    }

    public void createCourse(Course course){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO course (courseName,courseDescription) VALUES(?,?)");
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getCourseDescription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }

    }

    public void deleteCourse(Course course){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM course where id = ?");
            stmt.setInt(1, course.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }

    }

    public void assignCourseToInstitution(int institutionID, int courseID){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO institution_course (institution_id,course_id) VALUES (?,?)");
            stmt.setInt(1, institutionID);
            stmt.setInt(2, courseID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

    public void deleteCourseFromInstitution(int institutionID,int courseID){
        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("delete from institution_course WHERE institution_id = ? AND course_id = ?");
            stmt.setInt(1, institutionID);
            stmt.setInt(2, courseID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }
    }

}
