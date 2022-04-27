package by.bank.solution.command;

import by.bank.solution.entity.Phone;
import by.bank.solution.exception.ValidationException;
import by.bank.solution.service.PhoneService;
import by.bank.solution.service.UserDataService;
import by.bank.solution.service.UserService;
import by.bank.solution.validator.EmailValidator;
import by.bank.solution.validator.PhoneValidator;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
public class FillingUserDataCommand implements Command {

    private final UserDataService userDataService;
    private final UserService userService;
    private final PhoneService phoneService;
    private final static Logger LOGGER = Logger.getLogger(FillingUserDataCommand.class);


    @Override
    public CommandData execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            boolean isCreate = true;
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
            } else {
                sex = new Boolean(sexStr);
            }

            String passportNo = request.getParameter("passportNo");
            String issuedBy = request.getParameter("issuedBy");

            String whenIssuedStr = request.getParameter("whenIssued");
            LocalDate whenIssued = LocalDate.parse(whenIssuedStr);

            String identificationNo = request.getParameter("identificationNo");
            String placeBirth = request.getParameter("placeBirth");
            String cityActualResidence = request.getParameter("cityActualResidence");
            String address = request.getParameter("address");
            String homePhone = request.getParameter("homePhone");
            Optional<Phone> phone = phoneService.findByHomePhone(homePhone);
            if (phone.isPresent()) {
                request.setAttribute("homePhoneNotUnique", "Данный домашний номер телефона уже зарегистрирован!");
            }
            String mobilePhone = request.getParameter("mobilePhone");
            phone = phoneService.findByMobilePhone(mobilePhone);
            if (phone.isPresent()) {
                isCreate = false;
                request.setAttribute("mobilePhoneNotUnique", "Данный домашний номер телефона уже зарегистрирован!");
            }
            if (!PhoneValidator.validate(mobilePhone)) {
                isCreate = false;
                request.setAttribute("phoneIncorrect", "Не верно введён номер телефона!");
            }
            String email = request.getParameter("email");
            if (!EmailValidator.validate(email)) {
                isCreate = false;
                request.setAttribute("emailIncorrect", "Не верно введена почта!");
                throw new ValidationException();
            }
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

            Integer userId = (Integer) request.getSession().getAttribute("id");
            String login = (String) request.getSession().getAttribute("login");
            if (isCreate) {
                userDataService.createUserData(userId, name, surname, patronymic,
                        birthday, sex, passportNo, issuedBy, whenIssued,
                        identificationNo, placeBirth, cityActualResidence, address,
                        homePhone, mobilePhone, email, placeWork, position, cityResidence,
                        addressResidence, familyStatus, citizenship, disability, isPensioner, salary, isConscripts, login);
                userService.updateUserData(userId);
            }
        } catch (ValidationException e) {
            return CommandData.forward("WEB-INF/view/fillUserData.jsp");
        } catch (Exception e) {
            LOGGER.debug(e);
            request.setAttribute("incorrectData", "Введенные данные некорректны!");
            return CommandData.forward("WEB-INF/view/fillUserData.jsp");
        }
        return CommandData.forward("WEB-INF/view/main.jsp");
    }
}
