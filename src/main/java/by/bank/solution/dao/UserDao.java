package by.bank.solution.dao;

import by.bank.solution.entity.User;
import by.bank.solution.mapper.UserMapper;

import java.sql.SQLException;
import java.util.Optional;

public class UserDao extends Dao<User> {

    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login = ? AND password = ?";

    public Optional<User> findUserByLoginAndPassword(String login, String password) throws SQLException {
        return executeForSingleResult(FIND_BY_LOGIN_AND_PASSWORD, new UserMapper(), login, password);
    }

}
