package by.bank.solution.dao;

import by.bank.solution.entity.UserData;
import by.bank.solution.mapper.UserDataMapper;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class UserDataDao extends Dao<UserData> {

    private static final String GET_BY_ID = "SELECT * FROM users_data WHERE user_id = ?";
    private static final String CREATE = "INSERT INTO users_data(user_id, name, surname, patronymic, " +
            "birthday, sex, passport_series, passport_no, issued_by, when_issued, identification_no, place_birth, " +
            "city_actual_residence, address, home_phone, mobile_phone, email, place_work, position, city_residence, " +
            "address_residence, family_status, citizenship, disability, is_pensioner, salary, is_conscripts) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public Optional<UserData> getUserDataById(Integer id) throws SQLException {
        return executeForSingleResult(GET_BY_ID, new UserDataMapper(), id);
    }

    public void createUserData(Integer id, String name, String surname, String patronymic, LocalDate birthday, Boolean sex,
                               String passportSeries, String passportNo, String issuedBy, LocalDate whenIssued,
                               String identificationNo, String placeBirth, String cityActualResidence, String address,
                               String homePhone, String mobilePhone, String email, String placeWork, String position,
                               String cityResidence, String addressResidence, String familyStatus, String citizenship,
                               String disability, Boolean isPensioner, BigDecimal salary, Boolean isConscripts) throws SQLException {

        executeUpdate(CREATE, id, name, surname, patronymic, birthday, sex, passportSeries,
                passportNo, issuedBy, whenIssued, identificationNo, placeBirth, cityActualResidence, address,
                homePhone, mobilePhone, email, placeWork, position, cityResidence, addressResidence, familyStatus,
                citizenship, disability, isPensioner, salary, isConscripts);
    }
}
