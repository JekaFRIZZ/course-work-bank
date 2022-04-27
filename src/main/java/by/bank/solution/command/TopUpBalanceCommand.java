package by.bank.solution.command;

import by.bank.solution.entity.User;
import by.bank.solution.service.UserDataService;
import by.bank.solution.service.UserService;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.SQLException;
@AllArgsConstructor
public class TopUpBalanceCommand implements Command {

    private final UserService userService;
    private final UserDataService userDataService;

    @Override
    public CommandData execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Integer userId = (Integer) request.getSession().getAttribute("id");
        BigDecimal amount = new BigDecimal(request.getParameter("amount"));
        BigDecimal current = userDataService.getAccountBalanceByUserId(userId);
        if(current == null) {
            current = BigDecimal.ZERO;
        }
        try {
            userDataService.topUpBalance(amount.add(current), userId);
            request.setAttribute("balanceTopUp", "Баланс пополнен!");
        } catch (SQLException e) {
            request.setAttribute("balanceError", "Что-то пошло не так...");
        }

        return CommandData.forward("WEB-INF/view/TopUpBalance.jsp");
    }
}
