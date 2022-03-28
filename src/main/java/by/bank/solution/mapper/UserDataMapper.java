package by.bank.solution.mapper;

import by.bank.solution.entity.UserData;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class UserDataMapper implements RowMapper<UserData> {
    @Override
    public UserData map(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        Integer userId = resultSet.getInt("user_id");
        BigDecimal accountBalance = resultSet.getBigDecimal("account_balance");
        String address = resultSet.getString("address");
        String addressResidence = resultSet.getString("address_residence");
        LocalDate birthday = resultSet.getObject("birthday", LocalDate.class);
        System.out.println(birthday);
        String citizenship = resultSet.getString("citizenship");
        String cityActualResidence = resultSet.getString("city_actual_residence");
        String cityResidence = resultSet.getString("city_residence");
        String disability = resultSet.getString("disability");
        String email = resultSet.getString("email");
        String familyStatus = resultSet.getString("family_status");
        String homePhone = resultSet.getString("home_phone");
        String identificationNo = resultSet.getString("identification_no");
        Boolean isConscripts = resultSet.getBoolean("is_conscripts");
        Boolean isPensioner = resultSet.getBoolean("is_pensioner");
        String issuedBy = resultSet.getString("issued_by");
        String mobilePhone = resultSet.getString("mobile_phone");
        String name = resultSet.getString("name");
        String passportNo = resultSet.getString("passport_no");
        String passportSeries = resultSet.getString("passport_series");
        String patronymic = resultSet.getString("patronymic");
        String placeBirth = resultSet.getString("place_birth");
        String placeWork = resultSet.getString("place_work");
        String position = resultSet.getString("position");
        BigDecimal salary = resultSet.getBigDecimal("salary");
        Boolean sex = resultSet.getBoolean("sex");
        String surname = resultSet.getString("surname");
        LocalDate whenIssued = resultSet.getObject("when_issued", LocalDate.class);
        return new UserData(
                id, userId, accountBalance, name, surname, patronymic, birthday, sex,
                passportSeries, passportNo, issuedBy, whenIssued, identificationNo,
                placeBirth, cityActualResidence, address, homePhone, mobilePhone,
                email, placeWork, position, cityResidence, addressResidence, familyStatus,
                citizenship, disability, isPensioner, salary, isConscripts);
    }
}
