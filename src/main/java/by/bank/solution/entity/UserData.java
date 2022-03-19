package by.bank.solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserData {
    private Integer userId;
    private BigDecimal accountBalance;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDateTime birthday;
    private Boolean sex;
    private String passportSeries;
    private String passportNo;
    private String issuedBy;
    private LocalDateTime whenIssued;
    private String identificationNo;
    private String placeBirth;
    private String[] cityActualResidence;
    private String address;
    private String homePhone;
    private String mobilePhone;
    private String email;
    private String placeWork;
    private String position;
    private String[] cityResidence;
    private String addressResidence;
    private String familyStatus;
    private String citizenship;
    private String disability;
    private Boolean isPensioner;
    private BigDecimal salary;
    private Boolean isConscripts;
}
