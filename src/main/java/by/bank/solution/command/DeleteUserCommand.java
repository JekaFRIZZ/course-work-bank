package by.bank.solution.command;

import by.bank.solution.service.*;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@AllArgsConstructor
public class DeleteUserCommand implements Command {
    private final UserService userService;
    private final UserDataService userDataService;
    private final PhoneService phoneService;
    private final PassportService passportService;
    private final DepositService depositService;


    @Override
    public CommandData execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String userIdStr = request.getParameter("user_id");
        Integer userId = new Integer(userIdStr);
        depositService.deleteByUserId(userId);
        passportService.deleteByUserId(userId);
        phoneService.deleteByUserId(userId);
        userDataService.deleteByUserId(userId);
        userService.deleteByUserId(userId);
        return CommandData.redirect("/bank-solution?command=show_clients");
    }
}
