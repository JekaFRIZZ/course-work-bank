package by.bank.solution.mapper;

import by.bank.solution.entity.Passport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PassportMapper implements RowMapper<Passport> {
    @Override
    public Passport map(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String address = resultSet.getString("address");
        String cityActualResidence = resultSet.getString("city_actual_residence");
        String identificationNo = resultSet.getString("identification_no");
        String issuedBy = resultSet.getString("issued_by");
        String passportNo = resultSet.getString("passport_no");
        String placeBirth = resultSet.getString("place_birth");
        LocalDate whenIssued = resultSet.getObject("when_issued", LocalDate.class);
        Integer userId = resultSet.getInt("user_id");
        return new Passport(id, passportNo,issuedBy, whenIssued,
                identificationNo, placeBirth, cityActualResidence, address, userId);
    }
}
