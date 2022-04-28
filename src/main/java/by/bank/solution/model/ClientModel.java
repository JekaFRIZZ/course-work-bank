package by.bank.solution.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientModel {
    private Integer id;
    private String login;
    private String name;
    private String surname;
    private String patronymic;
    private String mobilePhone;
}
