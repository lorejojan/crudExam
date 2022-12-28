package crud.exam.bank.Repository;

import crud.exam.bank.DTO.CustomerDTO;
import crud.exam.bank.model.Account;
import crud.exam.bank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
