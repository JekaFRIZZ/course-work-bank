package by.bank.solution.mapper;

import by.bank.solution.entity.DepositType;
import by.bank.solution.entity.Role;
import by.bank.solution.entity.User;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepositTypeMapper implements RowMapper<DepositType>{
    @Override
    public DepositType map(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String current = resultSet.getString("current");
        Double income = resultSet.getDouble("income");
        BigDecimal minimumAmount = resultSet.getBigDecimal("minimum_amount");
        String name = resultSet.getString("name");
        Integer validity = resultSet.getInt("validity");
        return new DepositType(id, name, current, income, minimumAmount, validity);
    }
}
