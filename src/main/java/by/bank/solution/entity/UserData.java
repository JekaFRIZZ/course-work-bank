package by.bank.solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users_data")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;
    @Transient
    private Integer userIdInt;
    private BigDecimal accountBalance;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String patronymic;
    @Column(nullable = false)
    private LocalDate birthday;
    @Column(nullable = false)
    private Boolean sex;
    @Column(nullable = false)
    private String passportSeries;
    @Column(nullable = false)
    private String passportNo;
    @Column(nullable = false)
    private String issuedBy;
    @Column(nullable = false)
    private LocalDate whenIssued;
    @Column(nullable = false)
    private String identificationNo;
    @Column(nullable = false)
    private String placeBirth;
    @Column(nullable = false)
    private String cityActualResidence;
    @Column(nullable = false)
    private String address;
    private String homePhone;
    private String mobilePhone;
    private String email;
    private String placeWork;
    private String position;
    @Column(nullable = false)
    private String cityResidence;
    @Column(nullable = false)
    private String addressResidence;
    @Column(nullable = false)
    private String familyStatus;
    @Column(nullable = false)
    private String citizenship;
    @Column(nullable = false)
    private String disability;
    @Column(nullable = false)
    private Boolean isPensioner;
    private BigDecimal salary;
    @Column(nullable = false)
    private Boolean isConscripts;

    public UserData(Integer id, Integer userIdInt, BigDecimal accountBalance, String name, String surname,
                    String patronymic, LocalDate birthday, Boolean sex, String passportSeries, String passportNo,
                    String issuedBy, LocalDate whenIssued, String identificationNo, String placeBirth,
                    String cityActualResidence, String address, String homePhone, String mobilePhone, String email,
                    String placeWork, String position, String cityResidence, String addressResidence,
                    String familyStatus, String citizenship, String disability, Boolean isPensioner,
                    BigDecimal salary, Boolean isConscripts) {
        this.id = id;
        this.userId = userId;
        this.userIdInt = userIdInt;
        this.accountBalance = accountBalance;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.sex = sex;
        this.passportSeries = passportSeries;
        this.passportNo = passportNo;
        this.issuedBy = issuedBy;
        this.whenIssued = whenIssued;
        this.identificationNo = identificationNo;
        this.placeBirth = placeBirth;
        this.cityActualResidence = cityActualResidence;
        this.address = address;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.placeWork = placeWork;
        this.position = position;
        this.cityResidence = cityResidence;
        this.addressResidence = addressResidence;
        this.familyStatus = familyStatus;
        this.citizenship = citizenship;
        this.disability = disability;
        this.isPensioner = isPensioner;
        this.salary = salary;
        this.isConscripts = isConscripts;
    }
}
