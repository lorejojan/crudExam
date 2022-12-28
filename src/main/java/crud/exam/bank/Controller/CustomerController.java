package crud.exam.bank.Controller;

import crud.exam.bank.DTO.CustomerDTO;
import crud.exam.bank.Exception.CustomerException;
import crud.exam.bank.Service.CustomerService;
import crud.exam.bank.model.Customer;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer (@RequestBody CustomerDTO customerDTO) throws CustomerException {
        return new ResponseEntity<>("Registration Successful"
                + ":" + customerService.registerCustomer(customerDTO), HttpStatus.CREATED);
    }
    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) throws CustomerException {
       return new ResponseEntity<>(customerService.deleteCustomerAccountById(id),HttpStatus.OK);
    }

    @GetMapping("getCustomerById/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById (@PathVariable int id) throws  CustomerException{
        return new ResponseEntity<>(customerService.getCustomerById(id),HttpStatus.OK);
    }
    @GetMapping("getAllCustomer")
    public ResponseEntity<Collection<Customer>> getAllCustomer () throws  CustomerException{
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }
    @PutMapping("updateCustomer")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO,@PathVariable int id)throws CustomerException{
        return new ResponseEntity<>( customerService.updateCustomerDetails(customerDTO,id), HttpStatus.OK);
    }

}
