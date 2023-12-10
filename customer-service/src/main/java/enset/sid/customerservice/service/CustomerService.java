package enset.sid.customerservice.service;

import enset.sid.customerservice.entities.Customer;
import enset.sid.customerservice.exceptions.CustomerAllReadExistException;
import enset.sid.customerservice.exceptions.CustomerNotException;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer) throws CustomerAllReadExistException;
    Customer findCustomer(Long id) throws CustomerNotException;
    List<Customer> findAllCustomer();
    void deleteCustomer(Long id) throws  CustomerNotException;
    Customer editCustomer(Long id) throws  CustomerNotException;
}
