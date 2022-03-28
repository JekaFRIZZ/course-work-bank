package by.bank.solution.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ShowCommand implements Command {

    private final String page;

    public ShowCommand(String page) {
        this.page = page;
    }

    @Override
    public CommandData execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        return CommandData.forward(page);
    }
}
