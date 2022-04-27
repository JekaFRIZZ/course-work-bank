package by.bank.solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String login;
    private String password;
    private Boolean isUserData;
    @OneToOne(mappedBy = "userId")
    private UserData userData;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String email;

    public User(Integer id, String login, String password, Boolean isUserData, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isUserData = isUserData;
        this.role = role;
    }
}
