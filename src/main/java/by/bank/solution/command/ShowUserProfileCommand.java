package by.bank.solution.command;

import by.bank.solution.entity.DepositType;
import by.bank.solution.entity.Phone;
import by.bank.solution.entity.UserData;
import by.bank.solution.service.DepositTypeService;
import by.bank.solution.service.PhoneService;
import by.bank.solution.service.UserDataService;
import by.bank.solution.service.UserService;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@AllArgsConstructor
public class ShowUserProfileCommand implements Command {

    private final UserService userService;
    private final UserDataService userDataService;
    private final PhoneService phoneService;
    private final DepositTypeService depositTypeService;

    @Override
    public CommandData execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Integer userId = Integer.valueOf(request.getParameter("user_id"));
        Integer depositTypeId = Integer.valueOf(request.getParameter("deposit_type_id"));
        DepositType depositType = depositTypeService.findById(depositTypeId);
        UserData userData = userDataService.findById(userId);
        Phone phone = phoneService.findById(userId);
        request.setAttribute("userData", userData);
        request.setAttribute("phone", phone);
        request.setAttribute("userId", userId);
        request.setAttribute("deposit_type", depositType);
        return CommandData.forward("WEB-INF/view/UserProfileDeposit.jsp");
    }
}
