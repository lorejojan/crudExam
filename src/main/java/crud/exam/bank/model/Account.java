package crud.exam.bank.model;

import crud.exam.bank.DTO.AccountDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    @NotNull
    private int customerId;
    @NotNull
    private double accountBalance;

    public Account (AccountDTO accountDTO){
        this.accountId=accountDTO.getAccountId();
        this.customerId = accountDTO.getCustomerId();
        this.accountBalance=accountDTO.getAccountBalance();
    }
}
