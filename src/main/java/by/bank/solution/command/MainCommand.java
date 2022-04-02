package by.bank.solution.command;

import by.bank.solution.dao.UserDao;
import by.bank.solution.dao.UserDataDao;
import by.bank.solution.service.UserDataService;
import by.bank.solution.service.UserService;

import org.apache.log4j.Logger;

public class MainCommand {

    private static final Logger LOGGER = Logger.getLogger(MainCommand.class);

    private final UserService userService = new UserService(new UserDao());
    private final UserDataService userDataService = new UserDataService(new UserDataDao());

    public Command createCommand(String command) {
        LOGGER.debug(command);
        switch (command) {
            case "show_login" :
                return new ShowCommand("index.jsp");
            case "login":
                return new LoginCommand(userService);
            case "show_registration":
                return new ShowCommand("WEB-INF/view/registration.jsp");
            case "registration":
                return new RegistrationCommand(userService);
            case "showFillUserData":
                return new ShowCommand("WEB-INF/view/fillUserData.jsp");
            case "fillUserData":
                return new FillingUserDataCommand(userDataService);
            default:
                return null;
        }
    }
}
