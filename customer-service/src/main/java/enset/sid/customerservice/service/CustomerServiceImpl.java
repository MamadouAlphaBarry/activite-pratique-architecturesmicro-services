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
        log.info("CustomerService:findCustomer");

        Customer customer= customerRepository.findById(id).get();
        if (customer==null){
            log.info(String.format("Aucune Customer ne possede l'id %d",id));
            throw  new CustomerNotException(String.format("Aucune Customer ne possede l'id %d",id));
        }
        log.info("Customer Trouvè: "+customer);
        return mapper.fromCustomerToCustomerResponseDto(customer);
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
        Customer customer= customerRepository.findById(id).get();
        if (customer!=null){
            customerRepository.delete(customer);
            log.info("Le Client possedant l'id %d a etè supprimeè",id);
        }
        else {
            log.info(String.format("impossible de supprimer, Aucun Client  possedant l'id %d trouvè",id));
            throw new CustomerNotException(String.format("Aucun Client ne possedant l'id %d trouvè",id));
        };

    }

    /**
     * @param id
     * @return
     * @throws CustomerNotException
     */
    @Override
    public CustomerRequestDto editCustomer(Long id, CustomerRequestDto requestDto) throws CustomerNotException {
        CustomerRequestDto customerRequestDto =null;
        Customer customer= customerRepository.findById(id).get();
        if (customer!=null){
            customerRequestDto= mapper.fromCustomerToCustomerRequestDto(customer);
            if (requestDto.getAddress()!=null) customerRequestDto.setAddress(requestDto.getAddress());
            if (requestDto.getAge()!= 0) customerRequestDto.setAge(requestDto.getAge());
           // if (requestDto.getEmail() !=null) customerRequestDto.setEmail(requestDto.getEmail());
            if (requestDto.getFirstName()!=null) customerRequestDto.setFirstName(requestDto.getFirstName());
            if (requestDto.getLastName()!=null) customerRequestDto.setLastName(requestDto.getLastName());
            if (requestDto.getGender()!=null) customerRequestDto.setGender(requestDto.getGender());
            if (requestDto.getPhone()!=null) customerRequestDto.setPhone(requestDto.getPhone());
            if (requestDto.getPicture()!=null) customerRequestDto.setPicture(requestDto.getPicture());
            Customer savedCustomer= mapper.fromCustomerRequestDtoToCustomer(customerRequestDto);
            customerRepository.save(savedCustomer);
            return mapper.fromCustomerToCustomerRequestDto(savedCustomer);
        }



        return customerRequestDto;
    }

    /**
     * @param keyword
     * @return
     */
    @Override
    public List<CustomerResponseDto> searchFilteredCustomer(String keyword) {
        log.info("CustomerService:searchFilteredCustomer");

        List<Customer> customers= customerRepository.searchCustomers(keyword);
        if (!customers.isEmpty()) log.info("get customers by gived filtered string: "+customers);
        else    log.info("get customers by gived filtered string: Aucun Client trouvè");
        //log.info("get customers by gived filtered string: "+customers);
        List<CustomerResponseDto> customerResponseDtos= customers.stream().map(customer -> mapper.fromCustomerToCustomerResponseDto(customer)).toList();
        return customerResponseDtos;
    }

    /**
     * @param firstName
     * @return
     */
    @Override
    public CustomerResponseDto getCustomerByFirsName(String firstName) {
        return null;
    }

    /**
     * @param firstName
     * @param lastname
     * @return
     */
    @Override
    public List<CustomerResponseDto> getCustomerByFirstNameAndOrLastNameContainfilter(String firstName, String lastname) {
        return null;
    }
}
