package crud.exam.bank.model;

import crud.exam.bank.DTO.AccountDTO;
import crud.exam.bank.DTO.CustomerDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
/*@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))*/
public class Customer {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    @NotNull

    private String email;
    @OneToMany
    @JoinTable( name = "customerAccounts", joinColumns = @JoinColumn( name = "customerId", referencedColumnName = "customerId"))
    private Collection<Account> accounts;

    public Customer (CustomerDTO customerDTO){
        this.customerId = customerDTO.getCustomerId();
        this.firstName = customerDTO.getFirstName();
        this.lastName = customerDTO.getLastName();
        this.email = customerDTO.getEmail();
            Collection<AccountDTO> account = customerDTO.getAccounts();
        if(account != null) {
            for (AccountDTO x : account) {
                this.accounts.add(new Account(x));
            }
        }
    }
}
