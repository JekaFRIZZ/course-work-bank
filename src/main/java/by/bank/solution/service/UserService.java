package by.bank.solution.service;

import by.bank.solution.dao.UserDao;
import by.bank.solution.entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Optional;

public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Optional<User> login(String login, String password) throws SQLException {
        byte[] hashPassword = Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8));
        System.out.println(hashPassword);
        return userDao.findUserByLoginAndPassword(login, new String(hashPassword, StandardCharsets.UTF_8));
    }
}
