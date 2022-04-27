package by.bank.solution.mapper;

import by.bank.solution.entity.Role;
import by.bank.solution.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String login = resultSet.getString("login");
        Boolean isUserData = resultSet.getBoolean("is_user_data");
        String password = resultSet.getString("password");
        String roleString = resultSet.getString("role");
        Role role = Role.valueOf(roleString.toUpperCase());
        return new User(id, login, password, isUserData, role);
    }
}
