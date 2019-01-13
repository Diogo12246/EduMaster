package Model_DAO;

import ConnectionManager.ConnectionMasterBuilder;
import Model.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CourseDAO {

    ObservableList<Course> courses = FXCollections.observableArrayList();

    public ObservableList<Course> getCourses() {

        Connection con = ConnectionMasterBuilder.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM COURSE");
            while (rs.next()){
                courses.add(new Course(rs.getInt("id")
                        ,rs.getString("courseName"),
                        rs.getString("courseDescription")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }


}
