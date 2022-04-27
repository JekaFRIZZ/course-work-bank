package by.bank.solution.mapper;

import by.bank.solution.entity.Phone;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneMapper implements RowMapper<Phone> {
    @Override
    public Phone map(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String homePhone = resultSet.getString("home_phone");
        String mobilePhone = resultSet.getString("mobile_phone");
        Integer userId = resultSet.getInt("user_id");
        return new Phone(id, homePhone, mobilePhone, userId);
    }
}
