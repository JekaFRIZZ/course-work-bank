package by.bank.solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String homePhone;
    @Column(unique = true)
    private String mobilePhone;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;
    @Transient
    private Integer userIdInt;

    public Phone(Integer id, String homePhone, String mobilePhone, Integer userIdInt) {
        this.id = id;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.userIdInt = userIdInt;
    }
}
