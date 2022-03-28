package by.bank.solution.dao;

import by.bank.solution.mapper.RowMapper;
import org.apache.log4j.Logger;
import org.postgresql.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Dao<T> {

    Logger LOGGER = Logger.getLogger(Dao.class);

    private static final String MYSQL_URL = "jdbc:postgresql://localhost:5432/course-work-bank";
    private static final String MYSQL_USERNAME = "postgres";
    private static final String MYSQL_PASSWORD = "12345";
    private final Connection connection;

    public Dao(){
        connection = start();
    }

    private Connection start() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected List<T> executeQuery(String query, RowMapper<T> mapper, Object... params) throws SQLException {
        try (PreparedStatement statement = createStatement(query, params)) {
            ResultSet resultSet = statement.executeQuery();
            List<T> entities = new ArrayList<>();
            while (resultSet.next()) {
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException exception) {
            throw new SQLException(exception.getMessage(), exception);
        }
    }

    private PreparedStatement createStatement(String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        return statement;
    }

    protected Optional<T> executeForSingleResult(String query, RowMapper<T> mapper, Object... params) throws SQLException {
        List<T> items = executeQuery(query, mapper, params);
        if (items.size() == 1) {
            return Optional.of(items.get(0));
        } else if (items.size() > 1) {
            throw new IllegalArgumentException("More than one record");
        }
        return Optional.empty();
    }

    protected void executeUpdate(String query, Object... params) throws SQLException {
        try (PreparedStatement statement = createStatement(query, params)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug(e);
            throw new SQLException();
        }
    }
}
