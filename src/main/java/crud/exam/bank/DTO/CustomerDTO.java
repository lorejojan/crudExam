package crud.exam.bank.DTO;

import crud.exam.bank.model.Account;
import crud.exam.bank.model.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private int customerId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    @NotNull
    private String email;
    private Collection<AccountDTO> accounts;

    public CustomerDTO (Customer customer){
        this.customerId = customer.getCustomerId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        Collection<Account> account = customer.getAccounts();
        if(account != null) {
            for (Account x : account) {
                this.accounts.add(new AccountDTO(x));
            }
        }

    }



}
