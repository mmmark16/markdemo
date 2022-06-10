package org.mark.app.manager;

import org.mark.app.App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager {

    public static String getUserRole(String UserLogin, String UserPassword) throws SQLException {
        try(Connection c = App.getConnection()) {
            String sql = "SELECT * FROM users WHERE UserLogin=? AND UserPassword=?";

            PreparedStatement pr = c.prepareStatement(sql);

            pr.setString(1, UserLogin);
            pr.setString(2, UserPassword);

            ResultSet resultSet = pr.executeQuery();

            if (resultSet.next()){
                System.out.println(resultSet.getString("UserRole"));
                return resultSet.getString("UserRole");

            }
            return null;
        }
    }
}
