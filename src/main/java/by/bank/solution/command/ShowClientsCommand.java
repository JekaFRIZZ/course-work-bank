package by.bank.solution.command;

import by.bank.solution.entity.Phone;
import by.bank.solution.entity.User;
import by.bank.solution.entity.UserData;
import by.bank.solution.model.ClientModel;
import by.bank.solution.service.PhoneService;
import by.bank.solution.service.UserDataService;
import by.bank.solution.service.UserService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ShowClientsCommand implements Command {
    private final UserService userService;
    private final UserDataService userDataService;
    private final PhoneService phoneService;

    @SneakyThrows
    @Override
    public CommandData execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<User> users = userService.findAllUsers();
        List<User> usersSorted = users.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
        List<UserData> userDataList = new ArrayList<>();
        List<Phone> phoneList = new ArrayList<>();
        users.stream().forEach(user -> {
            try {
                userDataList.add(userDataService.findById(user.getId()));
                phoneList.add(phoneService.findById(user.getId()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        List<UserData> userDataSorted = userDataList.stream()
                .sorted(getHistoryComparator()).collect(Collectors.toList());
        List<Phone> phoneSorted = phoneList.stream()
                .sorted(Comparator.comparingLong(Phone::getUserIdInt)).collect(Collectors.toList());
        List<ClientModel> clientModels = new ArrayList<>();
        for (int i = 0; i < usersSorted.size(); i++) {
            ClientModel clientModel = new ClientModel();
            if(usersSorted.get(i).getIsUserData()) {
                clientModel.setLogin(usersSorted.get(i).getLogin());
                clientModel.setName(userDataSorted.get(i).getName());
                clientModel.setSurname(userDataSorted.get(i).getSurname());
                clientModel.setPatronymic(userDataSorted.get(i).getPatronymic());
                clientModel.setMobilePhone(phoneSorted.get(i).getMobilePhone());
            } else {
                clientModel.setLogin(usersSorted.get(i).getLogin());
                clientModel.setName("Нет данных!");
                clientModel.setSurname("Нет данных!");
                clientModel.setPatronymic("Нет данных!");
                clientModel.setMobilePhone("Нет данных!");
            }
        }
        request.setAttribute("clientModel", clientModels);
        return CommandData.forward("WEB-INF/view/ListClients.jsp");
    }

    private Comparator<UserData> getHistoryComparator() {
        Comparator<UserData> comparator = Comparator.comparingInt(UserData::getUserIdInt);
        return comparator;
    }
}
