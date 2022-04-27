package by.bank.solution.service;

import by.bank.solution.dao.PassportDao;
import by.bank.solution.entity.Passport;
import by.bank.solution.exception.UserDataNotExist;

import java.sql.SQLException;
import java.util.Optional;

public class PassportService {

    private final PassportDao passportDao;


    public PassportService(PassportDao passportDao) {
        this.passportDao = passportDao;
    }

    public Passport findByUserId(Integer userId) throws SQLException {
        return passportDao.findByUserId(userId).orElse(new Passport());
    }
}
