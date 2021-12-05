import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbTest {
    private static Connection CON = null;
    private static String USERNAME = "db2021_23";
    private static String PASSWORD = "61928534c4248";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://pdbmbook.com:3306/db2021_23";
    public static void main(String[] args){
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("FAIL");
            e.printStackTrace();
        }

        System.out.println();


    }
}
