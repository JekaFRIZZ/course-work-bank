package by.bank.solution.dao;

import by.bank.solution.entity.User;
import by.bank.solution.mapper.UserMapper;

import java.sql.SQLException;
import java.util.Optional;

public class UserDao extends Dao<User> {

    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login = ?";
    private static final String CREATE_USER = "INSERT INTO users(is_user_data, login, password, role) VALUES(?, ?, ?, ?)";
    private static final String FIND_BY_LOGIN = "SELECT * FROM users WHERE login = ?";

    public Optional<User> findUserByLogin(String login) throws SQLException {
        return executeForSingleResult(FIND_BY_LOGIN_AND_PASSWORD, new UserMapper(), login);
    }

    public void createUser(String login, String password, String role) throws SQLException {
        executeForSingleResult(CREATE_USER, new UserMapper(), false ,login, password, role);
    }

    public Optional<User> findPasswordByLogin(String login) throws SQLException {
        return executeForSingleResult(FIND_BY_LOGIN, new UserMapper(), login);
    }
}
