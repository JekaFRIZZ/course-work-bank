package by.bank.solution.controller;

import by.bank.solution.command.Command;
import by.bank.solution.command.CommandData;
import by.bank.solution.command.MainCommand;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/bank-solution")
public class Controller extends HttpServlet {

    private final MainCommand mainCommand = new MainCommand();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            common(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            common(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void common(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String commandType = req.getParameter("command");
        Command command = mainCommand.createCommand(commandType);
        command.execute(req, resp);
        String page;
        boolean isRedirect = false;
        try {
            CommandData result = command.execute(req, resp);
            page = result.getPage();
            isRedirect = result.isRedirect();
        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());
            page = "WEB-INF/view/errorPage.jsp";
        }
        if (!isRedirect) {
            req.getRequestDispatcher(page).forward(req, resp);
        } else {
            resp.sendRedirect(page);
        }
    }
}
