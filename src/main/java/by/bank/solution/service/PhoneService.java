package by.bank.solution.service;

import by.bank.solution.dao.PhoneDao;
import by.bank.solution.entity.Phone;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
public class PhoneService {

    private final PhoneDao phoneDao;

    public Phone findById(Integer userId) throws SQLException {
        return phoneDao.findById(userId).orElse(new Phone());
    }

    public Optional<Phone> findByHomePhone(String homePhone) throws SQLException {
        return phoneDao.findByHomePhone(homePhone);
    }

    public Optional<Phone> findByMobilePhone(String mobilePhone) throws SQLException {
        return phoneDao.findByMobilePhone(mobilePhone);
    }
}
