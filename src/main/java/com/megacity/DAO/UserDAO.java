package com.megacity.DAO;

import com.megacity.model.User;
import java.sql.SQLException;

public interface UserDAO {
    User getUserByUsername(String username) throws SQLException;
}
