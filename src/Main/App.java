package Main;

import Main.ui.AuthForm;
import Main.ui.ProductTableForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static boolean IS_ADMIN = false;
    public static void main(String[] args) {
        new AuthForm();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root","root");
    }
}
