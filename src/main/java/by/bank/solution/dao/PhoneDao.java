package by.bank.solution.dao;

import by.bank.solution.entity.Phone;
import by.bank.solution.mapper.PhoneMapper;

import java.sql.SQLException;
import java.util.Optional;

public class PhoneDao extends Dao<Phone> {
    public void createPhone(Integer userId, String homePhone, String mobilePhone) throws SQLException {
        executeUpdate("INSERT INTO phone(home_phone, mobile_phone, user_id) VALUES (?,?,?)", homePhone, mobilePhone, userId);
    }

    public Optional<Phone> findById(Integer userId) throws SQLException {
        return executeForSingleResult("SELECT * FROM phone WHERE user_id = ?", new PhoneMapper(), userId);
    }

    public Optional<Phone> findByHomePhone(String homePhone) throws SQLException {
        return executeForSingleResult("SELECT * FROM phone WHERE home_phone = ?", new PhoneMapper(), homePhone);
    }

    public Optional<Phone> findByMobilePhone(String mobilePhone) throws SQLException {
        return executeForSingleResult("SELECT * FROM phone WHERE mobile_phone = ?", new PhoneMapper(), mobilePhone);
    }
}
