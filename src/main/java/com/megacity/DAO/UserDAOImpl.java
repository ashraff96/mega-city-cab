package com.megacity.DAO;

import com.megacity.model.User;
import com.megacity.database.DBConnection;

import java.sql.*;

public class UserDAOImpl implements UserDAO {

    private static final String SELECT_USER_QUERY = "SELECT * FROM users WHERE username = ?";

    public User getUserByUsername(String username) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SELECT_USER_QUERY)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getString("username"), rs.getString("password"));
                }
            }
        }
        return null;
    }
}
