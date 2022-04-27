package by.bank.solution.dao;

import by.bank.solution.entity.DepositType;
import by.bank.solution.mapper.DepositTypeMapper;

import java.sql.SQLException;
import java.util.Optional;

public class DepositTypeDao extends Dao<DepositType> {
    public Optional<DepositType> findByName(String nameDeposit) throws SQLException {
        return executeForSingleResult("SELECT * FROM deposit_type WHERE name = ?", new DepositTypeMapper(),
                nameDeposit);
    }

    public Optional<DepositType> findById(Integer depositTypeId) throws SQLException {
        return executeForSingleResult("SELECT * FROM deposit_type WHERE id = ?" , new DepositTypeMapper(),
                depositTypeId);
    }
}
