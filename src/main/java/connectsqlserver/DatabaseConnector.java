
package connectsqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// DBContext class for handling database connections
public class DatabaseConnector  {
    private static final String SERVER_NAME = "KHOA"; // Your server name
    private static final String DATABASE_NAME = "northwind"; // Your database name
    private static final String USER = "sa"; // Your username
    private static final String PASSWORD = "5112"; // Your password
    private static final int PORT = 1433; // Default SQL Server port

    // Method to get a database connection
    public static Connection getConnection() {
        Connection c = null;
        try {
            // Load the SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // JDBC connection URL
            String url = "jdbc:sqlserver://" + SERVER_NAME + ":" + PORT + ";databaseName=" + DATABASE_NAME + ";encrypt=true;trustServerCertificate=true;";
            c = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Connection established successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        return c;
    }

    // Method to close the database connection
    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
                System.out.println("Connection closed successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
