package by.bank.solution.service;

import by.bank.solution.dao.UserDataDao;
import by.bank.solution.entity.UserData;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class UserDataService {

    private static final Logger LOGGER = Logger.getLogger(UserDataService.class);

    private final UserDataDao userDataDao;

    public UserDataService(UserDataDao userDataDao) {
        this.userDataDao = userDataDao;
    }

    public void createUserData(Integer id, String name, String surname, String patronymic, LocalDate birthday, Boolean sex,
                               String passportSeries, String passportNo, String issuedBy, LocalDate whenIssued, String identificationNo,
                               String placeBirth, String cityActualResidence, String address, String homePhone, String mobilePhone,
                               String email, String placeWork, String position, String cityResidence, String addressResidence,
                               String familyStatus, String citizenship, String disability, Boolean isPensioner, BigDecimal salary,
                               Boolean isConscripts) throws SQLException {
        if(checkIfExistUserData(id)) {
            LOGGER.debug("Such user exists!");
            throw new SQLException();
        }
        userDataDao.createUserData(id, name, surname, patronymic, birthday, sex, passportSeries, passportNo,
                issuedBy, whenIssued, identificationNo, placeBirth, cityActualResidence, address, homePhone,
                mobilePhone, email, placeWork, position, cityResidence, addressResidence, familyStatus, citizenship,
                disability, isPensioner, salary, isConscripts);
    }

    public boolean checkIfExistUserData(Integer id) throws SQLException {
        Optional<UserData> userDataById = userDataDao.getUserDataById(id);
        return userDataById.isPresent();
    }
}
