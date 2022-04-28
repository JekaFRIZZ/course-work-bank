package by.bank.solution.command;

import by.bank.solution.entity.*;
import by.bank.solution.model.ClientModel;
import by.bank.solution.model.DepositClientModel;
import by.bank.solution.service.*;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SearchUserCommand implements Command {
    private final UserService userService;
    private final UserDataService userDataService;
    private final PhoneService phoneService;
    private final DepositService depositService;
    private final DepositTypeService depositTypeService;

    @Override
    public CommandData execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String login = request.getParameter("login");
        Optional<User> userOptional = userService.findByLogin(login);
        if(userOptional.isEmpty()) {
            return CommandData.redirect("/bank-solution?command=show_clients");
        }
        Integer userId = userOptional.get().getId();
        UserData userData = userDataService.findById(userId);
        Phone phone = phoneService.findById(userId);
        ClientModel clientModel = new ClientModel();
        clientModel.setLogin(login);
        clientModel.setName(userData.getName());
        clientModel.setSurname(userData.getSurname());
        clientModel.setPatronymic(userData.getPatronymic());
        clientModel.setMobilePhone(phone.getMobilePhone());

        List<Deposit> deposits = depositService.findAllByUserId(userId);
        List<Integer> depositsIds = deposits.stream().map(Deposit::getDepositTypeIdInt).collect(Collectors.toList());
        List<DepositType> depositTypes = new ArrayList<>();
        for(int i = 0; i < depositsIds.size(); i++) {
            depositTypes.add(depositTypeService.findById(depositsIds.get(i)));
        }
        List<DepositClientModel> depositClientModels = new ArrayList<>();
        for(int i = 0; i < deposits.size(); i++) {
            DepositClientModel depositClientModel = new DepositClientModel();
            depositClientModel.setName(depositTypes.get(i).getName());
            depositClientModel.setCount(deposits.get(i).getAmount());
            depositClientModel.setValidity(deposits.get(i).getValidity());
            depositClientModels.add(depositClientModel);
        }
        request.setAttribute("clientModelSearch", clientModel);
        request.setAttribute("depositClientModels", depositClientModels);
        return CommandData.forward("WEB-INF/view/ListClients.jsp");
    }
}
