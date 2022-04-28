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
                if (user.getIsUserData()) {
                    userDataList.add(userDataService.findById(user.getId()));
                    phoneList.add(phoneService.findById(user.getId()));
                } else {
                    UserData userData = new UserData();
                    userData.setUserIdInt(user.getId());
                    Phone phone = new Phone();
                    phone.setUserIdInt(user.getId());
                    userDataList.add(userData);
                    phoneList.add(phone);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        List<UserData> userDataSorted = userDataList.stream()
                .sorted(Comparator.comparingInt(UserData::getUserIdInt)).collect(Collectors.toList());
        List<Phone> phoneSorted = phoneList.stream()
                .sorted(Comparator.comparingLong(Phone::getUserIdInt)).collect(Collectors.toList());
        List<ClientModel> clientModels = new ArrayList<>();
        List<ClientModel> clientModelsNoData = new ArrayList<>();
        for (int i = 0; i < usersSorted.size(); i++) {
            ClientModel clientModel = new ClientModel();
            if (usersSorted.get(i).getIsUserData()) {
                clientModel.setId(usersSorted.get(i).getId());
                clientModel.setLogin(usersSorted.get(i).getLogin());
                clientModel.setName(userDataSorted.get(i).getName());
                clientModel.setSurname(userDataSorted.get(i).getSurname());
                clientModel.setPatronymic(userDataSorted.get(i).getPatronymic());
                clientModel.setMobilePhone(phoneSorted.get(i).getMobilePhone());
                clientModels.add(clientModel);
            } else {
                clientModel.setId(usersSorted.get(i).getId());
                clientModel.setLogin(usersSorted.get(i).getLogin());
                clientModel.setName("Нет данных!");
                clientModel.setSurname("Нет данных!");
                clientModel.setPatronymic("Нет данных!");
                clientModel.setMobilePhone("Нет данных!");
                clientModelsNoData.add(clientModel);
            }
        }
        clientModels = clientModels.stream()
                .sorted(Comparator.comparing(ClientModel::getSurname)).collect(Collectors.toList());
        /*clientModels.sort((x1, x2) -> {
            if (x1.getSurname().equals("Нет данных!")) {
                return 1;
            }
            return -1;
        });*/
        /*for (int i = 0; i < clientModels.size(); i++) {
            ClientModel clientModel = clientModels.get(i);
            if (clientModels.get(i).getSurname().equals("Нет данных!")) {
                clientModels.remove(i);
                clientModels.add(clientModel);
            }
        }*/
        request.setAttribute("clientModel", clientModels);
        request.setAttribute("clientModelsNoData", clientModelsNoData);
        return CommandData.forward("WEB-INF/view/ListClients.jsp");
    }
}
