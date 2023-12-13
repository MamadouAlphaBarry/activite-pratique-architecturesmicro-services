package enset.sid.customerservice.service;

import enset.sid.customerservice.dao.CustomerRepository;
import enset.sid.customerservice.dtos.CustomerRequestDto;
import enset.sid.customerservice.dtos.CustomerResponseDto;
import enset.sid.customerservice.entities.Customer;
import enset.sid.customerservice.exceptions.CustomerAllReadExistException;
import enset.sid.customerservice.exceptions.CustomerNotException;
import enset.sid.customerservice.mappers.CustomerMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class CustomerServiceImpl implements CustomerService{
    private CustomerMapper mapper;
    private CustomerRepository customerRepository;

    /**
     * @param customer
     * @return
     * @throws CustomerAllReadExistException
     */
    @Override
    public CustomerResponseDto addCustomer(CustomerRequestDto customer) throws CustomerAllReadExistException {
        log.info("**********************DEBUT ADD CUSTOMER IN DATABASE*****************************");
        if (customerRepository.checkIfEmailExist(customer.getEmail())){
            throw new CustomerAllReadExistException(String.format("L'email %s existe deja ",customer.getEmail()));
        }
        Customer savedCustomer= mapper.fromCustomerRequestDtoToCustomer(customer);
        customerRepository.save(savedCustomer);
        CustomerResponseDto customerResponseDto= mapper.fromCustomerToCustomerResponseDto(savedCustomer);
        log.info(String.format("Le Client avec l'id %d à ètè enregistrer",savedCustomer.getId()));
        log.info("savedCustomer: "+savedCustomer.toString());
        return customerResponseDto;
    }

    /**
     * @param id
     * @return
     * @throws CustomerNotException
     */
    @Override
    public CustomerResponseDto findCustomer(Long id) throws CustomerNotException {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<CustomerResponseDto> findAllCustomer() {
       List<Customer> customers= customerRepository.findAll();
       List<CustomerResponseDto> responseDtoList= customers.stream().map(customer -> mapper.fromCustomerToCustomerResponseDto(customer)).toList();
        return responseDtoList;
    }

    /**
     * @param id
     * @throws CustomerNotException
     */
    @Override
    public void deleteCustomer(Long id) throws CustomerNotException {

    }

    /**
     * @param id
     * @return
     * @throws CustomerNotException
     */
    @Override
    public CustomerRequestDto editCustomer(Long id) throws CustomerNotException {
        return null;
    }
}
