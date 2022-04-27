package by.bank.solution.service;

import by.bank.solution.dao.DepositTypeDao;
import by.bank.solution.entity.DepositType;
import by.bank.solution.exception.DepositTypeNotFoundException;
import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class DepositTypeService {

    private final DepositTypeDao depositTypeDao;

    public DepositType findByName(String nameDeposit) throws Exception {
        return depositTypeDao.findByName(nameDeposit).orElseThrow(DepositTypeNotFoundException::new);
    }

    public DepositType findById(Integer depositTypeId) throws SQLException {
        return depositTypeDao.findById(depositTypeId).orElse(new DepositType());
    }
}
