package by.bank.solution.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositClientModel {
    private String name;
    private BigDecimal count;
    private Integer validity;
}
