package by.bank.solution.command;

import by.bank.solution.entity.DepositType;
import by.bank.solution.service.DepositTypeService;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@AllArgsConstructor
public class ShowEnterDepositCommand implements Command {

    private final DepositTypeService depositTypeService;

    @Override
    public CommandData execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String nameDeposit = request.getParameter("name_deposit");
        try {
            DepositType depositType = depositTypeService.findByName(nameDeposit);
            request.setAttribute("name_deposit", nameDeposit);
            request.setAttribute("min_amount", depositType.getMinimumAmount());
            request.setAttribute("min_validity", depositType.getValidity());
        } catch (Exception e) {
            request.setAttribute("notFoundDeposit", "Deposit not found!");
        }
        return CommandData.forward("WEB-INF/view/depositInfo.jsp");
    }
}
