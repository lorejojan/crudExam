package crud.exam.bank.Service;

import crud.exam.bank.DTO.CustomerDTO;
import crud.exam.bank.Exception.CustomerException;
import crud.exam.bank.Repository.AccountRepository;
import crud.exam.bank.Repository.CustomerRepository;
import crud.exam.bank.model.Account;
import crud.exam.bank.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerDTO registerCustomer(CustomerDTO customerDTO) {
            return new CustomerDTO(customerRepository.save(new Customer(customerDTO)));
    }

    @Override
    public String deleteCustomerAccountById(int customerId) throws CustomerException {
        if (!customerRepository.existsById(customerId)) {
            throw new CustomerException("Customer Account with id: "+customerId+" Not found!");
        }
        customerRepository.deleteById(customerId);
        return "Customer Account with id " +customerId + " has been deleted successfully.";
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) throws CustomerException {
        return new CustomerDTO(customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerException( "Customer with id " +customerId + " not found!")));
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerDTO updateCustomerDetails(CustomerDTO customerDTO, int customerId) throws CustomerException {

        return customerRepository.findById(customerId)
                .map(customer -> {
                    customer.setAccounts(new Customer(customerDTO).getAccounts());
                    customer.setEmail(customerDTO.getEmail());
                    customer.setLastName(customerDTO.getLastName());
                    customer.setFirstName(customerDTO.getFirstName());
                    return  new CustomerDTO(customerRepository.save(customer));
                }).orElseThrow(() -> new CustomerException( "Customer with id " +customerId + " not found!"));

    }


}
