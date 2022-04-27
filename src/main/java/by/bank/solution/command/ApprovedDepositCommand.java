package by.bank.solution.command;

import by.bank.solution.entity.Deposit;
import by.bank.solution.entity.DepositType;
import by.bank.solution.entity.User;
import by.bank.solution.entity.UserData;
import by.bank.solution.service.DepositService;
import by.bank.solution.service.DepositTypeService;
import by.bank.solution.service.UserDataService;
import by.bank.solution.service.UserService;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
public class ApprovedDepositCommand implements Command {

    private final DepositService depositService;
    private final UserDataService userDataService;
    private final DepositTypeService depositTypeService;
    private final UserService userService;

    @Override
    public CommandData execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Integer userId = Integer.valueOf(request.getParameter("user_id"));
        Integer depositTypeId = Integer.valueOf(request.getParameter("deposit_type_id"));
        String approved = request.getParameter("result_approved_deposit");
        Boolean isApproved = Boolean.valueOf(approved);
        if(isApproved) {
            DepositType depositType = depositTypeService.findById(depositTypeId);
            UserData userData = userDataService.findById(userId);
            if(userData.getAccountBalance().compareTo(depositType.getMinimumAmount()) >= 0) {
                depositService.approvedDeposit(userId, depositTypeId);
                userDataService.minusAccountBalance(
                        userData.getAccountBalance().subtract(depositType.getMinimumAmount()), userId);
            } else {
                depositService.updateStatusClosed(depositTypeId, userId);
            }
        } else {
            depositService.updateStatusClosed(depositTypeId, userId);
        }
        List<Deposit> deposits = depositService.findNotApproved();
        List<User> users = new ArrayList<>();
        List<DepositType> depositTypes = new ArrayList<>();
        for(Deposit deposit: deposits) {
            DepositType depositType = depositTypeService.findById(depositTypeId);
            depositTypes.add(depositType);
            User user = userService.findById(deposit.getUserIdInt());
            users.add(user);
        }
        Map<DepositType, User> mapDepositAndUser = IntStream.range(0, depositTypes.size()).boxed()
                .collect(Collectors.toMap(depositTypes::get, users::get));
        request.setAttribute("mapDepositAndUser", mapDepositAndUser);
        return CommandData.forward("WEB-INF/view/RequestDeposit.jsp");
    }
}
