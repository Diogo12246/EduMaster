package pt.diogo12246.Model_DAO;

import pt.diogo12246.ConnectionManager.ConnectionMasterBuilder;
import pt.diogo12246.Model.Course;
import pt.diogo12246.Model.Institution;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CourseDAO {


    /*
    THIS IS THE DAO FOR SAID OBJECT.
    YOU CAN FIND ALL METHODS OF ACCESS LAYER HERE
 */


    private ObservableList<Course> courses = FXCollections.observableArrayList();
    private ObservableList<Institution> coursesInstitutions = FXCollections.observableArrayList();

    public ObservableList<Course> getCourses() {
        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM course");
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

    public double getCoursesProgress() {
        Connection con = ConnectionMasterBuilder.getConnection();
        double value = 0.0;
        try {
            PreparedStatement statement =  con.prepareStatement("SELECT count(id) from course");
            ResultSet rs = statement.executeQuery();
            rs.next();
            String sum = rs.getString(1);
            double valueRaw = Double.parseDouble(sum);
            //formula//
            value = valueRaw / 1000;
            //////////
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }


    public String getCoursesCount() {
        Connection con = ConnectionMasterBuilder.getConnection();
        String value = "";
        try {
            PreparedStatement statement =  con.prepareStatement("SELECT count(id) from course");
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
