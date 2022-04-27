package by.bank.solution.service;

import by.bank.solution.dao.UserDao;
import by.bank.solution.entity.Role;
import by.bank.solution.entity.User;
import by.bank.solution.exception.UserNotFoundException;
import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserService {

    private final static Logger LOGGER = Logger.getLogger(UserService.class);
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Optional<User> login(String login, String password) throws SQLException {
        Optional<User> hashPasswordFromDBOptional = userDao.findPasswordByLogin(login);
        if (hashPasswordFromDBOptional.isPresent()) {
            String hashPasswordFromDB = hashPasswordFromDBOptional.get().getPassword();
            if (BCrypt.checkpw(password, hashPasswordFromDB)) {
                return userDao.findUserByLogin(login);
            }
        }
        LOGGER.debug("Incorrect password");
        return Optional.empty();
    }

    public void registration(String login, String password) throws SQLException {
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
        userDao.createUserRegistration(login, hashPassword, Role.USER.toString());
    }

    public Optional<User> findByLogin(String login) throws SQLException {
        return userDao.findUserByLogin(login);
    }

    public void updateUserEmail(String login, String email) throws Exception {
        userDao.updateUserEmail(login, email);
    }

    public void updateUserData(Integer userId) throws SQLException {
        userDao.updateUserData(userId);
    }

    public User findById(Integer userId) throws SQLException {
        return userDao.findById(userId).orElse(new User());
    }

    public List<User> findAllUsers() throws SQLException {
        return userDao.findAllUsers();
    }
}
