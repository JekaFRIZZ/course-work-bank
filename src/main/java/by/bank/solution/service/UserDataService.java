package by.bank.solution.service;

import by.bank.solution.dao.PassportDao;
import by.bank.solution.dao.PhoneDao;
import by.bank.solution.dao.UserDataDao;
import by.bank.solution.entity.UserData;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
public class UserDataService {

    private static final Logger LOGGER = Logger.getLogger(UserDataService.class);

    private final UserDataDao userDataDao;
    private final PhoneDao phoneDao;
    private final PassportDao passportDao;
    private final UserService userService;

    public void createUserData(Integer userId, String name, String surname, String patronymic, LocalDate birthday, Boolean sex,
                               String passportNo, String issuedBy, LocalDate whenIssued, String identificationNo,
                               String placeBirth, String cityActualResidence, String address, String homePhone, String mobilePhone,
                               String email, String placeWork, String position, String cityResidence, String addressResidence,
                               String familyStatus, String citizenship, String disability, Boolean isPensioner, BigDecimal salary,
                               Boolean isConscripts, String login) throws Exception {
        if(checkIfExistUserData(userId)) {
            LOGGER.debug("Such user exists!");
            throw new SQLException();
        }
        phoneDao.createPhone(userId, homePhone, mobilePhone);
        passportDao.createPassport(userId, passportNo, issuedBy, whenIssued, identificationNo, placeBirth,
                cityActualResidence, address);
        userService.updateUserEmail(login, email);
        userDataDao.createUserData(userId, name, surname, patronymic, birthday, sex,
                placeWork, position, cityResidence, addressResidence, familyStatus, citizenship,
                disability, isPensioner, salary, isConscripts);
    }

    public boolean checkIfExistUserData(Integer id) throws SQLException {
        Optional<UserData> userDataById = userDataDao.getUserDataById(id);
        return userDataById.isPresent();
    }

    public UserData findById(Integer userId) throws SQLException {
        return userDataDao.getUserDataById(userId).orElse(new UserData());
    }

    public BigDecimal getAccountBalanceByUserId(Integer userId) throws SQLException {
        UserData userData = userDataDao.getUserDataById(userId).orElse(new UserData());
        return userData.getAccountBalance();
    }

    public void topUpBalance(BigDecimal amount, Integer userId) throws SQLException {
        userDataDao.updateAccountBalance(amount, userId);
    }

    public void minusAccountBalance(BigDecimal amount, Integer userId) throws SQLException {
        userDataDao.updateAccountBalance(amount, userId);
    }

    public void deleteByUserId(Integer userId) throws SQLException {
        userDataDao.deleteByUserId(userId);
    }
}
