package by.bank.solution.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class LogoutCommand implements Command {
    @Override
    public CommandData execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        request.getSession().invalidate();
        return CommandData.forward("index.jsp");
    }
}
