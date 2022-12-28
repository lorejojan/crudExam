package crud.exam.bank.DTO;

import crud.exam.bank.model.Account;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private int accountId;
    @NotNull
    private int customerId;
    @NotNull
    private double accountBalance;

    public AccountDTO (Account account){
        this.accountId=account.getAccountId();
        this.customerId = account.getCustomerId();
        this.accountBalance=account.getAccountBalance();
    }
}
