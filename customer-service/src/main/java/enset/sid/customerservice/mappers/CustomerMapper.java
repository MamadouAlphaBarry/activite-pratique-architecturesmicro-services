package enset.sid.customerservice.mappers;

import enset.sid.customerservice.dtos.CustomerRequestDto;
import enset.sid.customerservice.dtos.CustomerResponseDto;
import enset.sid.customerservice.entities.Customer;

public interface CustomerMapper {
    Customer fromCustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto);
    CustomerRequestDto fromCustomerToCustomerRequestDto(Customer customer);
    Customer fromCustomerResponseDtoToCustomer(CustomerResponseDto customerResponseDto);
    CustomerResponseDto fromCustomerToCustomerResponseDto(Customer customer);
}
