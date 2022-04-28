package by.bank.solution.command;

import by.bank.solution.dao.*;
import by.bank.solution.service.*;

import org.apache.log4j.Logger;

public class MainCommand {

    private static final Logger LOGGER = Logger.getLogger(MainCommand.class);

    private final UserService userService = new UserService(new UserDao());
    private final UserDataService userDataService = new UserDataService(new UserDataDao(), new PhoneDao(),
            new PassportDao(), userService);
    private final DepositService depositService = new DepositService(new DepositDao());
    private final DepositTypeService depositTypeService = new DepositTypeService(new DepositTypeDao());
    private final PhoneService phoneService = new PhoneService(new PhoneDao());
    private final PassportService passportService = new PassportService(new PassportDao());

    public Command createCommand(String command) {
        LOGGER.debug(command);
        switch (command) {
            case "show_login" :
                return new ShowCommand("index.jsp");
            case "login" :
                return new LoginCommand(userService);
            case "show_registration" :
                return new ShowCommand("WEB-INF/view/registration.jsp");
            case "registration" :
                return new RegistrationCommand(userService);
            case "show_fill_user_data" :
                return new ShowCommand("WEB-INF/view/fillUserData.jsp");
            case "fill_user_data" :
                return new FillingUserDataCommand(userDataService, userService, phoneService);
            case "show_main" :
                return new ShowCommand("WEB-INF/view/main.jsp");
            case "show_deposit":
                 return new ShowCommand("WEB-INF/view/deposit.jsp");
            case "make_deposit" :
                return new MakeDepositCommand(depositService, depositTypeService, userService, userDataService);
            case "show_request_deposit" :
                return new ShowRequestDepositCommand(depositService, userService, depositTypeService);
            case "show_user_profile" :
                return new ShowUserProfileCommand(userService, userDataService, phoneService, depositTypeService);
            case "show_top_up_balance" :
                return new ShowCommand("WEB-INF/view/TopUpBalance.jsp");
            case "top_up_balance" :
                return new TopUpBalanceCommand(userService, userDataService);
            case "approved_deposit" :
                return new ApprovedDepositCommand(depositService, userDataService, depositTypeService, userService);
            case "show_enter_deposit" :
                return new ShowEnterDepositCommand(depositTypeService);
            case "show_profile" :
                return new ShowProfileCommand(userService, phoneService,userDataService, passportService);
            case "show_clients" :
                return new ShowClientsCommand(userService, userDataService, phoneService);
            case "delete_user" :
                return new DeleteUserCommand(userService, userDataService, phoneService, passportService, depositService);
            case "search_user" :
                return new SearchUserCommand(userService, userDataService, phoneService, depositService, depositTypeService);
            case "logout" :
                return new LogoutCommand();
            default:
                return null;
        }
    }
}
