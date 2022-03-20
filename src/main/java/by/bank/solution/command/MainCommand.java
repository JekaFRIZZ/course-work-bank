package by.bank.solution.command;

import by.bank.solution.dao.UserDao;
import by.bank.solution.service.UserService;

public class MainCommand {

    private final UserService userService = new UserService(new UserDao());

    public Command createCommand(String command) {
        switch (command) {
            case "login":
                return new LoginCommand(userService);
            default:
                return null;
        }
    }
}
