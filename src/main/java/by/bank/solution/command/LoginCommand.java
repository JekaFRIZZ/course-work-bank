package by.bank.solution.command;

import by.bank.solution.entity.User;
import by.bank.solution.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Optional;

public class LoginCommand implements Command {

    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandData execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Optional<User> userOptional = userService.login(login, password);

        if(userOptional.isPresent()) {
            User user = userOptional.get();
            session.setAttribute("username", login);
            return CommandData.forward("index.jsp");
        }
        return null;
    }
}
