package by.bank.solution.command;

import antlr.collections.impl.IntRange;
import by.bank.solution.entity.Deposit;
import by.bank.solution.entity.DepositType;
import by.bank.solution.entity.User;
import by.bank.solution.service.DepositService;
import by.bank.solution.service.DepositTypeService;
import by.bank.solution.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.valves.rewrite.InternalRewriteMap;
import org.apache.tomcat.util.http.fileupload.util.Streams;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
public class ShowRequestDepositCommand implements Command {

    private final DepositService depositService;
    private final UserService userService;
    private final DepositTypeService depositTypeService;

    @Override
    public CommandData execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Deposit> deposits = depositService.findNotApproved();
        List<User> users = new ArrayList<>();
        List<DepositType> depositTypes = new ArrayList<>();
        for(Deposit deposit: deposits) {
            Integer depositTypeId = deposit.getDepositTypeIdInt();
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
