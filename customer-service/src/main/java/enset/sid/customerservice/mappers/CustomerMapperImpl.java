package enset.sid.customerservice.mappers;

import enset.sid.customerservice.dtos.CustomerRequestDto;
import enset.sid.customerservice.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapperImpl implements  CustomerMapper{
    @Override
    public Customer fromCustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto) {
        return null;
    }

    @Override
    public CustomerRequestDto fromCustomerToCustomerRequestDto(Customer customer) {
        return null;
    }
}
