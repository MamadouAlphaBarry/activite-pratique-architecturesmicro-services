package enst.sid.accountservice.client;

import enst.sid.accountservice.model.Customer;
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
    ResponseEntity<?> findCustomerById(@PathVariable Long id);
    @GetMapping("/cusotmers")
    List<Customer> findAllClient();
}
