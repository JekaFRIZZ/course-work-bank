package by.bank.solution.dao;

import by.bank.solution.entity.User;
import by.bank.solution.mapper.UserMapper;

import java.sql.SQLException;
import java.util.Optional;

public class UserDao extends Dao<User> {

    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login = ? AND password = ?";
    private static final String CREATE_USER = "INSERT INTO users(login, password, role) VALUES(?, ?, ?)";

    public Optional<User> findUserByLoginAndPassword(String login, String password) throws SQLException {
        return executeForSingleResult(FIND_BY_LOGIN_AND_PASSWORD, new UserMapper(), login, password);
    }

    public void createUser(String login, String password, String role) throws SQLException {
        executeForSingleResult(CREATE_USER, new UserMapper() ,login, password, role);
    }
}
