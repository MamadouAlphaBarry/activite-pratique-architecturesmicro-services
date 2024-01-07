package enst.sid.accountservice.client;

import enst.sid.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
@Service
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    ResponseEntity<?> findCustomerById(@PathVariable Long id);
    @GetMapping("/cusotmers")
    @Retry(name = "retrySearchCustomers", fallbackMethod = "getDefaultCustomers")
    List<Customer> findAllClient();

    default CustomerResponseDto getDefaultCustomer(Long id,Exception e){
        return CustomerResponseDto.builder()
                .id(id).email("noname@gmail.com").firstName("defaultFirstName for => "+id).lastName("defaultLast for => "+id).build();
    }
    default List<CustomerResponseDto> getDefaultCustomers(){
        return List.of();
    }
}
