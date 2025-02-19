package com.megacity.service;

import com.megacity.DAO.UserDAO;
import com.megacity.DAO.UserDAOImpl;
import com.megacity.model.User;
import java.sql.SQLException;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAOImpl();
    }

    public boolean authenticateUser(String username, String password) {
        try {
            User user = userDAO.getUserByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


