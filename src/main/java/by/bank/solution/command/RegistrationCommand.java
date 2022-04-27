package by.bank.solution.command;

import by.bank.solution.entity.User;
import by.bank.solution.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;

public class RegistrationCommand implements Command {

    private static final String REGISTRATION_PAGE = "WEB-INF/view/registration.jsp";
    private static final String LOGIN_PAGE = "index.jsp";
    private final UserService userService;

    public RegistrationCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandData execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");

        if (comparePassword(password, passwordConfirm)) {
            Optional<User> userOptional = userService.findByLogin(login);
            if (userOptional.isEmpty()) {
                userService.registration(login, password);
                return CommandData.forward(LOGIN_PAGE);
            } else {
                request.setAttribute("notUniqueUser", "User with this login exists");
                return CommandData.forward(REGISTRATION_PAGE);
            }
        }
        request.setAttribute("passwordNotEquals", "Passwords aren't equal");
        return CommandData.forward(REGISTRATION_PAGE);
    }

    private boolean comparePassword(String password, String passwordConfirm) {
        return password.equals(passwordConfirm);
    }
}
