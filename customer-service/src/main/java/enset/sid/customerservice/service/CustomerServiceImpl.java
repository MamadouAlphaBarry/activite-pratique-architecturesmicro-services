package enset.sid.customerservice.service;

import enset.sid.customerservice.dao.CustomerRepository;
import enset.sid.customerservice.entities.Customer;
import enset.sid.customerservice.exceptions.CustomerAllReadExistException;
import enset.sid.customerservice.exceptions.CustomerNotException;
import enset.sid.customerservice.mappers.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private CustomerMapper mapper;
    private CustomerRepository customerRepository;
    @Override
    public Customer addCustomer(Customer customer) throws CustomerAllReadExistException {

        return null;
    }

    @Override
    public Customer findCustomer(Long id) throws CustomerNotException {
        return null;
    }

    @Override
    public List<Customer> findAllCustomer() {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) throws CustomerNotException {

    }

    @Override
    public Customer editCustomer(Long id) throws CustomerNotException {
        return null;
    }
}
