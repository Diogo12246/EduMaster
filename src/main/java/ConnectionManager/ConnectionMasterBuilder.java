package ConnectionManager;

import utility.EduExceptionHandler;

import java.sql.*;

public class ConnectionMasterBuilder {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/EduMaster_Test";
    private static final String USER = "root";
    private static final String PASS = "root";

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
