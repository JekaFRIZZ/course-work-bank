package by.bank.solution.service;

import by.bank.solution.dao.UserDao;
import by.bank.solution.entity.Role;
import by.bank.solution.entity.User;
import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.util.Optional;

public class UserService {

    private final static Logger LOGGER = Logger.getLogger(UserService.class);
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Optional<User> login(String login, String password) throws SQLException {
        Optional<User> hashPasswordFromDBOptional = userDao.findPasswordByLogin(login);
        if(hashPasswordFromDBOptional.isPresent()) {
            String hashPasswordFromDB = hashPasswordFromDBOptional.get().getPassword();
            if(BCrypt.checkpw(password, hashPasswordFromDB)){
                return userDao.findUserByLogin(login);
            }
        }
        LOGGER.debug("Incorrect password");
        return Optional.empty();
    }

    public void registration(String login, String password) throws SQLException {
        try {
            String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
            userDao.createUser(login, hashPassword, Role.USER.toString());
        }catch (SQLException e) {
            LOGGER.debug(e);
        }
    }
}
