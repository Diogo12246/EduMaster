package Model_DAO;

import ConnectionManager.ConnectionMasterBuilder;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public void createUser(User user) {

        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO user (userName,userPassword) VALUES(?,?)");
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getUserPassword());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt);
        }

    }

    public boolean validateUser(String userName, String userPassword) {

        Connection con = ConnectionMasterBuilder.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean valid = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM user WHERE UserName = ?");
            stmt.setString(1, userName);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String password = rs.getString("UserPassword");
                if (password.equals(userPassword)){
                    valid =true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMasterBuilder.closeConnection(con, stmt, rs);
        }
        return valid;
    }
}
