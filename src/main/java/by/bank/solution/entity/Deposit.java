package by.bank.solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;
    @Transient
    private Integer userIdInt;
    @Transient
    private Integer depositTypeIdInt;
    @ManyToOne
    @JoinColumn(name = "deposit_type_id", referencedColumnName = "id")
    private DepositType depositType;
    private LocalDate openingDay;
    private Boolean status;
    private BigDecimal income;
    private Boolean approved;
    private BigDecimal amount;
    private Integer validity;

    public Deposit(Integer id, Integer userIdInt, Integer depositTypeIdInt, LocalDate openingDay, Boolean status,
                   BigDecimal income, Boolean approved, BigDecimal amount, Integer validity) {
        this.id = id;
        this.userIdInt = userIdInt;
        this.depositTypeIdInt = depositTypeIdInt;
        this.openingDay = openingDay;
        this.status = status;
        this.income = income;
        this.approved = approved;
        this.amount = amount;
        this.validity = validity;
    }
}
