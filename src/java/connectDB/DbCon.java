package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {

    private static DbCon instance;

    private DbCon() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;"
                + "databaseName=ecommerce_cart;User=sa;Password=123;encrypt=true;trustServerCertificate=true";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(connectionUrl);
    }

    public static synchronized DbCon getInstance() {
        if (instance == null) {
            instance = new DbCon();
        }
        return instance;
    }
}
