package crud.exam.bank.Controller;

import crud.exam.bank.DTO.AccountDTO;
import crud.exam.bank.DTO.CustomerDTO;
import crud.exam.bank.Exception.CustomerException;
import crud.exam.bank.Service.AccountService;
import crud.exam.bank.Service.CustomerService;
import crud.exam.bank.model.Account;
import crud.exam.bank.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountException;
import java.util.Collection;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/addAccount")
    public ResponseEntity<String> addAccount (@RequestBody AccountDTO accountDTO,@PathVariable int customerId) throws AccountException {
        return new ResponseEntity<>("Account added"
                + ":" + accountService.addAccount(accountDTO,customerId), HttpStatus.CREATED);
    }
    @DeleteMapping("deleteAccountById/{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable int id) throws AccountException {
        return new ResponseEntity<>(accountService.deleteAccountById(id),HttpStatus.OK);
    }

    @GetMapping("getAccountById/{id}")
    public ResponseEntity<AccountDTO> getAccountById (@PathVariable int id) throws  AccountException{
        return new ResponseEntity<>(accountService.getAccountById(id),HttpStatus.OK);
    }
    @GetMapping("getAllAccount")
    public ResponseEntity<Collection<Account>> getAllAccount () throws  AccountException{
        return new ResponseEntity<>(accountService.getAllAccount(), HttpStatus.OK);
    }
    @PutMapping("deposit")
    public ResponseEntity<AccountDTO> deposit(@RequestBody double amouont,@PathVariable int id)throws AccountException{
        return new ResponseEntity<>( accountService.deposit(amouont,id), HttpStatus.OK);
    }
}
