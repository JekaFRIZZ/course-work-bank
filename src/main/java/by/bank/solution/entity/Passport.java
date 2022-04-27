package by.bank.solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    @Transient
    private Integer userIdInt;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Passport(Integer id, String passportNo, String issuedBy, LocalDate whenIssued,
                    String identificationNo, String placeBirth, String cityActualResidence, String address, Integer userIdInt) {
        this.id = id;
        this.passportNo = passportNo;
        this.issuedBy = issuedBy;
        this.whenIssued = whenIssued;
        this.identificationNo = identificationNo;
        this.placeBirth = placeBirth;
        this.cityActualResidence = cityActualResidence;
        this.address = address;
        this.userIdInt = userIdInt;
    }
}
