package by.bank.solution.dao;

import by.bank.solution.entity.Deposit;
import by.bank.solution.mapper.DepositMapper;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class DepositDao extends Dao<Deposit> {
    public void create(Integer userId, Integer depositTypeId, Double income, boolean approved,
                       BigDecimal amount, Integer validity) throws SQLException {
        executeUpdate("INSERT INTO deposit(user_id, deposit_type_id, income, approved, amount, validity) VALUES (?,?,?,?,?,?)",
                userId, depositTypeId, income, approved, amount, validity);
    }

    public List<Deposit> findNotApproved() throws SQLException {
        return executeQuery("SELECT * FROM deposit WHERE approved = false AND status is NULL", new DepositMapper());
    }

    public void updateApprovedTrueByUserId(Integer userId, Integer depositTypeId) throws SQLException {
        executeUpdate("UPDATE deposit SET approved = true, opening_day = now(), status = true " +
                "WHERE user_id = ? AND opening_day is NULL AND deposit_type_id = ?", userId, depositTypeId);
    }

    public void updateStatusFalse(Integer depositTypeId, Integer userId) throws SQLException {
        executeUpdate("UPDATE deposit SET status = false WHERE deposit_type_id = ? AND user_id = ?",
                depositTypeId, userId);
    }

    public void deleteByUserId(Integer userId) throws SQLException {
        executeUpdate("DELETE FROM deposit WHERE user_id =?", userId);
    }

    public List<Deposit> findAllByUserId(Integer userId) throws SQLException {
        return executeQuery("SELECT * FROM deposit WHERE user_id = ?", new DepositMapper(), userId);
    }
}
