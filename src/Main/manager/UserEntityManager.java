package Main.manager;

import Main.App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserEntityManager {

    public static String getUserRole(String login, String password) throws SQLException {
        try(Connection c = App.getConnection()) {
            String sql = "Select * From Users Where UserLogin = ? And UserPassword = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("UserRole");
            }
            return null;
        }
    }
}
