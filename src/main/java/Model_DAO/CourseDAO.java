package Model_DAO;

import ConnectionManager.ConnectionMasterBuilder;
import Model.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CourseDAO {

    ObservableList<Course> courses = FXCollections.observableArrayList();

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
            System.out.println(course.getCourseName() + " " + course.getId());
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

}
