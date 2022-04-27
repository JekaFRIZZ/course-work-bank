package by.bank.solution.command;

import by.bank.solution.entity.DepositType;
import by.bank.solution.entity.User;
import by.bank.solution.service.DepositService;
import by.bank.solution.service.DepositTypeService;
import by.bank.solution.service.UserDataService;
import by.bank.solution.service.UserService;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
public class MakeDepositCommand implements Command {

    private final DepositService depositService;
    private final DepositTypeService depositTypeService;
    private final UserService userService;
    private final UserDataService userDataService;

    @Override
    public CommandData execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String nameDeposit = request.getParameter("name_deposit");
        try {
            DepositType depositType = depositTypeService.findByName(nameDeposit);
            String login = (String) request.getSession().getAttribute("login");
            Optional<User> userOptional = userService.findByLogin(login);
            if (userOptional.isPresent()) {
                boolean isUserData = userOptional.get().getIsUserData();
                if (isUserData) {
                    Integer userId = userOptional.get().getId();
                    BigDecimal amount = new BigDecimal(request.getParameter("amount"));
                    Integer validity = Integer.valueOf(request.getParameter("validity"));
                    if (amount.compareTo(depositType.getMinimumAmount()) >= 0 &&
                            validity >= depositType.getValidity()) {
                        BigDecimal accountBalance = userDataService.getAccountBalanceByUserId(userId);
                        if(accountBalance.compareTo(amount) >= 0) {
                            depositService.create(userId, depositType.getId(), depositType.getIncome(), false,
                                    amount, validity);
                            request.setAttribute("MakeDepositSuccessful", "Вы подали заявку на оформление депозита!");
                        } else {
                            request.setAttribute("NotEnoughBalance", "Недостаточно средств для оформления депозита!");
                        }
                    } else {
                        request.setAttribute("name_deposit", nameDeposit);
                        request.setAttribute("min_amount", depositType.getMinimumAmount());
                        request.setAttribute("min_validity", depositType.getValidity());
                        request.setAttribute("IncorrectValues", "Неверные данные введены!");
                        return CommandData.forward("WEB-INF/view/depositInfo.jsp");
                    }
                } else {
                    request.setAttribute("MakeDepositNotSuccessful", "Заполните необходимые данные!");
                    request.setAttribute("name_deposit", nameDeposit);
                    request.setAttribute("min_amount", depositType.getMinimumAmount());
                    request.setAttribute("min_validity", depositType.getValidity());
                    return CommandData.forward("WEB-INF/view/depositInfo.jsp");
                }
            }
        } catch (Exception e) {
            request.setAttribute("notFoundDeposit", "Deposit not found!");
        }
        return CommandData.forward("WEB-INF/view/deposit.jsp");
    }
}
