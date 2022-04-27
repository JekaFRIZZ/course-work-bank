package by.bank.solution.dao;

import by.bank.solution.entity.Passport;
import by.bank.solution.mapper.PassportMapper;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class PassportDao extends Dao<Passport> {
    public void createPassport(Integer userId, String passportNo, String issuedBy, LocalDate whenIssued,
                               String identificationNo, String placeBirth, String cityActualResidence, String address) throws SQLException {
        executeUpdate("INSERT INTO passport(address, city_actual_residence, identification_no, issued_by, " +
                        "passport_no, place_birth, when_issued, user_id) VALUES(?,?,?,?,?,?,?,?)",
                address, cityActualResidence, identificationNo, issuedBy, passportNo, placeBirth, whenIssued, userId);
    }

    public Optional<Passport> findByUserId(Integer userId) throws SQLException {
        return executeForSingleResult("SELECT * FROM passport WHERE user_id = ?", new PassportMapper(), userId);
    }
}
