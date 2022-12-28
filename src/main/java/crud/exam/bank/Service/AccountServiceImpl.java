package crud.exam.bank.Service;

import crud.exam.bank.DTO.AccountDTO;
import crud.exam.bank.DTO.CustomerDTO;
import crud.exam.bank.Exception.CustomerException;
import crud.exam.bank.Repository.AccountRepository;
import crud.exam.bank.model.Account;
import crud.exam.bank.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.AccountException;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public AccountDTO addAccount(AccountDTO accountDTO,int customerId) throws AccountException {
        accountDTO.setCustomerId(customerId);
        return new AccountDTO(accountRepository.save(new Account(accountDTO)));
    }

    @Override
    public AccountDTO getAccountById(int accountId) throws AccountException {
        return new AccountDTO(accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountException( "Account with id " +accountId + " not found!")));
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public String deleteAccountById(int accountId) throws AccountException {
        if (!accountRepository.existsById(accountId)) {
            throw new AccountException(" Account with id: "+accountId+" Not found!");
        }
        accountRepository.deleteById(accountId);
        return " Account with id " +accountId + " has been deleted successfully.";
    }

    @Override
    public AccountDTO deposit(double amount, int accountId) throws AccountException {
        return accountRepository.findById(accountId)
                .map(account -> {
                    account.setAccountBalance(account.getAccountBalance() + amount);
                    return  new AccountDTO(accountRepository.save(account));
                }).orElseThrow(() -> new AccountException( "Account with id " +accountId + " not found!"));

    }
}
