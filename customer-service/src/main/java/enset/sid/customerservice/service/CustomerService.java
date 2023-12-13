package enset.sid.customerservice.service;

import enset.sid.customerservice.dtos.CustomerRequestDto;
import enset.sid.customerservice.dtos.CustomerResponseDto;
import enset.sid.customerservice.entities.Customer;
import enset.sid.customerservice.exceptions.CustomerAllReadExistException;
import enset.sid.customerservice.exceptions.CustomerNotException;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto addCustomer(CustomerRequestDto customer) throws CustomerAllReadExistException;
    CustomerResponseDto findCustomer(Long id) throws CustomerNotException;
    List<CustomerResponseDto> findAllCustomer();
    void deleteCustomer(Long id) throws  CustomerNotException;
    CustomerRequestDto editCustomer(Long id) throws  CustomerNotException;
}
