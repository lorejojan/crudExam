package crud.exam.bank.Service;

import crud.exam.bank.DTO.AccountDTO;
import crud.exam.bank.DTO.CustomerDTO;
import crud.exam.bank.Exception.CustomerException;
import crud.exam.bank.model.Account;
import crud.exam.bank.model.Customer;

import javax.security.auth.login.AccountException;
import java.util.List;

public interface AccountService {

    public AccountDTO addAccount (AccountDTO accountDTO,int customerId) throws AccountException;
    public AccountDTO getAccountById(int accountId) throws AccountException;
    public List<Account> getAllAccount();
    public String deleteAccountById(int accountId) throws AccountException;

    public AccountDTO deposit(double amount, int accountId) throws AccountException;
}
