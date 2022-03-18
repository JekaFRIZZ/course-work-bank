package by.bank.solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserData {
    //TODO correct translate each field
    private Integer userId;
    private BigDecimal accountBalance;
    private String firstname;
    private String lastname;
    private String patronymic;
    private LocalDateTime birthday;
    private Boolean sex;
    private String serialPassport;
    private String numberPassport;
    private String whoGiven;
    private LocalDateTime whenGiven;
    private String identityNumber;
    private String placeBirthday;
    private String[] cities;
    private String address;
    private String homePhone;
    private String mobilePhone;
    private String email;
    private String workPlace;
    private String stuffing;//должность
    private String[] citiesPropiski;
    private String addressPropiski;
    private String familyStatus;
    private String grajdanstvo;
    private String invalidnost;
    private Boolean pensioner;
    private BigDecimal salary;
    private Boolean warStatus;
}
