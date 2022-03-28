package by.bank.solution.command;

import by.bank.solution.service.UserDataService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FillingUserDataCommand implements Command {

    private final UserDataService userDataService;
    private final static Logger LOGGER = Logger.getLogger(FillingUserDataCommand.class);


    public FillingUserDataCommand(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @Override
    public CommandData execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String patronymic = request.getParameter("patronymic");

            String birthdayStr = request.getParameter("birthday");
            LocalDate birthday = LocalDate.parse(birthdayStr);

            String sexStr = request.getParameter("sex");
            Boolean sex = false;
            if (!(sexStr.equals("true") || sexStr.equals("false"))) {
                request.setAttribute("incorrectSex", "The entered sex is incorrect");
                throw new SQLException();
            } else  {
                sex = new Boolean(sexStr);
            }

            String passportSeries = request.getParameter("passportSeries");
            String passportNo = request.getParameter("passportNo");
            String issuedBy = request.getParameter("issuedBy");

            String whenIssuedStr = request.getParameter("whenIssued");
            LocalDate whenIssued = LocalDate.parse(whenIssuedStr);

            String identificationNo = request.getParameter("identificationNo");
            String placeBirth = request.getParameter("placeBirth");
            String cityActualResidence = request.getParameter("cityActualResidence");
            String address = request.getParameter("address");
            String homePhone = request.getParameter("homePhone");
            String mobilePhone = request.getParameter("mobilePhone");//make validation
            String email = request.getParameter("email");//make validation
            String placeWork = request.getParameter("placeWork");
            String position = request.getParameter("position");
            String cityResidence = request.getParameter("cityResidence");
            String addressResidence = request.getParameter("addressResidence");
            String familyStatus = request.getParameter("familyStatus");
            String citizenship = request.getParameter("citizenship");
            String disability = request.getParameter("disability");

            String isPensionerStr = request.getParameter("isPensioner");
            Boolean isPensioner;
            if (!(isPensionerStr.equals("true") || isPensionerStr.equals("false"))) {
                request.setAttribute("incorrectPensioner", "The entered status is incorrect");
                throw new SQLException();
            } else {
                isPensioner = new Boolean(isPensionerStr);
            }

            String salaryStr = request.getParameter("salary");
            BigDecimal salary = new BigDecimal(salaryStr);

            String isConscriptsStr = request.getParameter("isConscripts");
            Boolean isConscripts;
            if (!(isConscriptsStr.equals("true") || isConscriptsStr.equals("false"))) {
                request.setAttribute("incorrectConscripts", "The entered conscripts is incorrect");
                throw new SQLException();
            } else {
                isConscripts = new Boolean(isConscriptsStr);
            }

            Integer id = (Integer) request.getSession().getAttribute("id");
            userDataService.createUserData(1, name, surname, patronymic,
                    birthday, sex, passportSeries, passportNo, issuedBy, whenIssued,
                    identificationNo, placeBirth, cityActualResidence, address,
                    homePhone, mobilePhone, email, placeWork, position, cityResidence,
                    addressResidence, familyStatus, citizenship, disability, isPensioner, salary, isConscripts);
        } catch (Exception e) {
            LOGGER.debug(e);
            return CommandData.forward("WEB-INF/view/fillUserData.jsp");
        }
        return CommandData.forward("WEB-INF/view/main.jsp");
    }
}
