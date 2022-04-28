package by.bank.solution.service;

import by.bank.solution.dao.DepositDao;
import by.bank.solution.entity.Deposit;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class DepositService {

    private final DepositDao depositDao;

    public void create(Integer userId, Integer depositTypeId, Double income, boolean approved,
                       BigDecimal amount, Integer validity) throws SQLException {
        depositDao.create(userId, depositTypeId, income, approved, amount, validity);
    }

    public List<Deposit> findNotApproved() throws SQLException {
        return depositDao.findNotApproved();
    }

    public void approvedDeposit(Integer userId, Integer depositTypeId) throws SQLException {
        depositDao.updateApprovedTrueByUserId(userId, depositTypeId);
    }

    public void updateStatusClosed(Integer depositTypeId, Integer userId) throws SQLException {
        depositDao.updateStatusFalse(depositTypeId, userId);
    }

    public void deleteByUserId(Integer userId) throws SQLException {
        depositDao.deleteByUserId(userId);
    }

    public List<Deposit> findAllByUserId(Integer userId) throws SQLException {
        return depositDao.findAllByUserId(userId);
    }
}
