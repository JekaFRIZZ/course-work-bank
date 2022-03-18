package by.bank.solution.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    CommandData execute(HttpServletRequest request, HttpServletResponse response);
}
