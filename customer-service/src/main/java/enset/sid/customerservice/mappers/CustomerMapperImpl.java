package enset.sid.customerservice.mappers;

import enset.sid.customerservice.dtos.CustomerRequestDto;
import enset.sid.customerservice.dtos.CustomerResponseDto;
import enset.sid.customerservice.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapperImpl implements  CustomerMapper{
    @Override
    public Customer fromCustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerRequestDto.getFirstName());
        customer.setLastName(customerRequestDto.getLastName());
        customer.setAddress(customerRequestDto.getAddress());
        customer.setAge(customerRequestDto.getAge());
        customer.setGender(customerRequestDto.getGender());
        customer.setPhone(customerRequestDto.getPhone());
        customer.setPicture(customerRequestDto.getPicture());
        customer.setEmail(customerRequestDto.getEmail());
        return customer;
    }

    @Override
    public CustomerRequestDto fromCustomerToCustomerRequestDto(Customer customer) {
        CustomerRequestDto customerRequestDto= CustomerRequestDto.builder()
                .address(customer.getAddress())
                .phone(customer.getPhone())
                .age(customer.getAge())
                .picture(customer.getPicture())
                .lastName(customer.getLastName())
                .firstName(customer.getFirstName())
                .gender(customer.getGender())
                .email(customer.getEmail())
                .build();
        return customerRequestDto;
    }

    @Override
    public Customer fromCustomerResponseDtoToCustomer(CustomerResponseDto customerResponseDto) {
        Customer customer= Customer.builder()
                .id(customerResponseDto.getId())
                .firstName(customerResponseDto.getFirstName())
                .lastName(customerResponseDto.getLastName())
                .address(customerResponseDto.getAddress())
                .picture(customerResponseDto.getPicture())
                .email(customerResponseDto.getEmail())
                .age(customerResponseDto.getAge())
                .gender(customerResponseDto.getGender())
                .phone(customerResponseDto.getPhone())
                .build();
        return customer;
    }

    @Override
    public CustomerResponseDto fromCustomerToCustomerResponseDto(Customer customer) {
        CustomerResponseDto customerResponseDto= CustomerResponseDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .address(customer.getAddress())
                .picture(customer.getPicture())
                .gender(customer.getGender())
                .age(customer.getAge())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
        return customerResponseDto;
    }
}
