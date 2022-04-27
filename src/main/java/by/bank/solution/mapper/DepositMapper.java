package by.bank.solution.mapper;

import by.bank.solution.entity.Deposit;
import by.bank.solution.entity.DepositType;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DepositMapper implements RowMapper<Deposit> {
    @Override
    public Deposit map(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        Boolean approved = resultSet.getBoolean("approved");
        BigDecimal income = resultSet.getBigDecimal("income");
        LocalDate openingDay = resultSet.getObject("opening_day", LocalDate.class);
        Boolean status = resultSet.getBoolean("status");
        Integer depositTypeId = resultSet.getInt("deposit_type_id");
        Integer userId = resultSet.getInt("user_id");
        BigDecimal amount = resultSet.getBigDecimal("amount");
        Integer validity = resultSet.getInt("validity");
        return new Deposit(id, userId , depositTypeId, openingDay, status, income, approved, amount, validity);
    }
}
