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
        String addressResidence = resultSet.getString("address_residence");
        LocalDate birthday = resultSet.getObject("birthday", LocalDate.class);
        String citizenship = resultSet.getString("citizenship");
        String cityResidence = resultSet.getString("city_residence");
        String disability = resultSet.getString("disability");
        String familyStatus = resultSet.getString("family_status");
        Boolean isConscripts = resultSet.getBoolean("is_conscripts");
        Boolean isPensioner = resultSet.getBoolean("is_pensioner");
        String name = resultSet.getString("name");
        String patronymic = resultSet.getString("patronymic");
        String placeWork = resultSet.getString("place_work");
        String position = resultSet.getString("position");
        BigDecimal salary = resultSet.getBigDecimal("salary");
        Boolean sex = resultSet.getBoolean("sex");
        String surname = resultSet.getString("surname");
        return new UserData(
                id, userId, accountBalance, name, surname, patronymic, birthday, sex,
                placeWork, position, cityResidence, addressResidence, familyStatus,
                citizenship, disability, isPensioner, salary, isConscripts);
    }
}
