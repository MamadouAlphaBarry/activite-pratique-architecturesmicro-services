package enset.sid.customerservice.web;

import enset.sid.customerservice.dtos.CustomerRequestDto;
import enset.sid.customerservice.dtos.CustomerResponseDto;
import enset.sid.customerservice.exceptions.CustomerAllReadExistException;
import enset.sid.customerservice.service.CustomerService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerRestController {
    private CustomerService customerService;
   @PostMapping("/customers")
    public ResponseEntity<?> saveNewCustomer(@RequestBody CustomerRequestDto customerRequestDto){
      try {
          CustomerResponseDto customerResponseDto=  customerService.addCustomer(customerRequestDto);
          return ResponseEntity.ok(customerResponseDto);
      }catch (CustomerAllReadExistException exception){
          return ResponseEntity.internalServerError().body(exception.getMessage());
      }
    }
    @GetMapping("/customers")
    List<CustomerResponseDto> getAllCustomer(){
     return customerService.findAllCustomer() ;
    }
}
