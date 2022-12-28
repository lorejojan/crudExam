package crud.exam.bank.Service;

import crud.exam.bank.DTO.CustomerDTO;
import crud.exam.bank.Exception.CustomerException;
import crud.exam.bank.model.Customer;

import java.util.List;

public interface CustomerService {
    public CustomerDTO registerCustomer (CustomerDTO customerDTO) throws CustomerException;
    public String deleteCustomerAccountById(int customerId) throws CustomerException;
    public CustomerDTO getCustomerById(int customerId) throws  CustomerException;
    public List<Customer> getAllCustomer();
    public CustomerDTO updateCustomerDetails(CustomerDTO customerDTO, int customerId) throws CustomerException;
}
