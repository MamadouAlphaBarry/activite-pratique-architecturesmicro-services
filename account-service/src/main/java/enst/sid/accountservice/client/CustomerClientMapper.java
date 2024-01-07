package enst.sid.accountservice.client;

import enst.sid.accountservice.model.Customer;
import org.springframework.stereotype.Service;

@Service

public class CustomerClientMapper {
    public Customer fromCustomerToCustomerResponseDto(CustomerResponseDto customerResponseDto)
    {
        Customer customer = new Customer();
        customer.setId(customer.getId());
        customer.setAge(customerResponseDto.getAge());
        customer.setGender(customerResponseDto.getGender());
        customer.setEmail(customerResponseDto.getEmail());
        customer.setAddress(customerResponseDto.getAddress());
        customer.setPhone(customerResponseDto.getPhone());
        customer.setPicture(customerResponseDto.getPicture());
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        return  customer;
    }
}
