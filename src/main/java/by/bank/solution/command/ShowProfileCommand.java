package by.bank.solution.command;

import by.bank.solution.entity.Passport;
import by.bank.solution.entity.Phone;
import by.bank.solution.entity.User;
import by.bank.solution.entity.UserData;
import by.bank.solution.service.PassportService;
import by.bank.solution.service.PhoneService;
import by.bank.solution.service.UserDataService;
import by.bank.solution.service.UserService;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
public class ShowProfileCommand implements Command {
    private final UserService userService;
    private final PhoneService phoneService;
    private final UserDataService userDataService;
    private final PassportService passportService;

    @Override
    public CommandData execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Integer userId = (Integer) request.getSession().getAttribute("id");

        UserData userData = userDataService.findById(userId);
        Phone phone = phoneService.findById(userId);
        Passport passport = passportService.findByUserId(userId);
        User user = userService.findById(userId);

        request.setAttribute("phone", phone);
        request.setAttribute("passport", passport);
        request.setAttribute("user", user);
        request.setAttribute("userData", userData);

        return CommandData.forward("WEB-INF/view/UserProfile.jsp");
    }
}
