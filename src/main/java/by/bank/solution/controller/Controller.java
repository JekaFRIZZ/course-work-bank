package by.bank.solution.controller;

import by.bank.solution.connection.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/bank-solution")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        common(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        common(req, resp);
    }

    private void common(HttpServletRequest req, HttpServletResponse resp) {
        Connection connection = ConnectionFactory.create();
        System.out.println(connection);
        String commandType = req.getParameter("command");
        System.out.println(commandType);
    }
}
