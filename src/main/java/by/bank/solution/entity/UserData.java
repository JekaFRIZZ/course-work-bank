package by.bank.solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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
                    String patronymic, LocalDate birthday, Boolean sex, String placeWork, String position,
                    String cityResidence, String addressResidence, String familyStatus, String citizenship,
                    String disability, Boolean isPensioner, BigDecimal salary, Boolean isConscripts) {
        this.id = id;
        this.userIdInt = userIdInt;
        this.accountBalance = accountBalance;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.sex = sex;
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
