package pt.diogo12246.ConnectionManager;

import pt.diogo12246.utility.EduExceptionHandler;

import java.sql.*;

public class ConnectionMasterBuilder {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://85.246.4.194:3306/edumaster_test";
    // since its hosted on my Raspberry PI3 db access for testing hidden for obvious reasons //
    private static final String USER = "d12246";
    private static final String PASS = "some_strong_password";
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                EduExceptionHandler.ThrowEX(e);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement statmt, ResultSet rs) {
        closeConnection(con, statmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            EduExceptionHandler.ThrowEX(e);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            EduExceptionHandler.ThrowEX(e);
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("An error in the connection has occurred." +
                    "please contact an administrator", e);
        }

    }


}
