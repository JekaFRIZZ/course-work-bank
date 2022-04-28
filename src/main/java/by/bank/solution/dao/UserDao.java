package by.bank.solution.dao;

import by.bank.solution.entity.Role;
import by.bank.solution.entity.User;
import by.bank.solution.mapper.UserMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDao extends Dao<User> {

    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login = ?";
    private static final String CREATE_USER = "INSERT INTO users(is_user_data, login, password, role) " +
            "VALUES(?, ?, ?, ?)";
    private static final String FIND_BY_LOGIN = "SELECT * FROM users WHERE login = ?";

    public Optional<User> findUserByLogin(String login) throws SQLException {
        return executeForSingleResult(FIND_BY_LOGIN, new UserMapper(), login);
    }

    public void createUserRegistration(String login, String password, String role) throws SQLException {
        executeUpdate(CREATE_USER, false ,login, password, role);
    }

    public Optional<User> findPasswordByLogin(String login) throws SQLException {
        return executeForSingleResult(FIND_BY_LOGIN, new UserMapper(), login);
    }

    public void updateUserEmail(String login, String email) throws SQLException {
        executeUpdate("UPDATE users SET email = ? WHERE login = ?", email, login);
    }

    public void updateUserData(Integer userId) throws SQLException {
        executeUpdate("UPDATE users SET is_user_data = true WHERE id = ?", userId);
    }

    public Optional<User> findById(Integer userId) throws SQLException {
        return executeForSingleResult("SELECT * FROM users WHERE id = ?", new UserMapper(), userId);
    }

    public List<User> findAllUsers() throws SQLException {
        return executeQuery("SELECT * FROM users WHERE role = ?", new UserMapper(), "USER");
    }

    public void deleteByUserId(Integer userId) throws SQLException {
        executeUpdate("DELETE FROM users WHERE id = ?", userId);
    }
}
