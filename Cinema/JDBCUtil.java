package Cinema;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cinema",
                    "root",
                    "qwertyui");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}