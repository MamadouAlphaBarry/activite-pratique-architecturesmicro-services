package enset.sid.customerservice.web;

import enset.sid.customerservice.dao.CustomerRepository;
import enset.sid.customerservice.dtos.CustomerRequestDto;
import enset.sid.customerservice.dtos.CustomerResponseDto;
import enset.sid.customerservice.entities.Customer;
import enset.sid.customerservice.exceptions.CustomerAllReadExistException;
import enset.sid.customerservice.exceptions.CustomerNotException;
import enset.sid.customerservice.service.CustomerService;
import lombok.AllArgsConstructor;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class CustomerRestController {
    private CustomerService customerService;
  private   CustomerRepository customerRepository;


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
    ResponseEntity<?> getAllCustomer(){
        HashMap<String, Object> map= new LinkedHashMap<String, Object>();
        List<CustomerResponseDto> customerList= customerService.findAllCustomer();
        if (!customerList.isEmpty()){
            map.put("status",1);
            map.put("data", customerList);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }else{
            map.clear();
            map.put("status",0);
            map.put("data","Aucune donnèe trouvèe");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }

    }
   @GetMapping("/customer/search")
    public ResponseEntity<?> searchCustomer(@Param("kw") String kw){
       HashMap<String, Object> map= new LinkedHashMap<String, Object>();
       List<CustomerResponseDto> responseDtoList= customerService.searchFilteredCustomer(kw);
       if (!responseDtoList.isEmpty()){
           map.put("status",1);
           map.put("data",responseDtoList);
           return  new ResponseEntity<>(map,HttpStatus.OK);
       }else {
           map.clear();
           map.put("status",1);
           map.put("data", "Aucun customer contenant le filtre donnè n'a etè trouvè");
           return  new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
       }


    }
    @GetMapping("/customers/{id}")
   public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id){
       HashMap<String,Object> map= new LinkedHashMap<String, Object>();
        try {
            CustomerResponseDto customerResponseDto= customerService.findCustomer(id);
            if (customerResponseDto != null){

                map.put("status",1);
                map.put("data",customerResponseDto);
                return  new ResponseEntity<>(map,HttpStatus.OK);
            }else{
                map.put("status",1);
                map.put("data",String.format("Aucune Client possede l'identifiant %d",id));
            }
        } catch (CustomerNotException e) {
            throw new RuntimeException(e);
        }
        return  null;
    }

   /* Customer findById(@PathVariable Long id){
        return  customerRepository.findById(id).get();
    }*/

    @PutMapping("/customer/{id}")
    public ResponseEntity<?> editCustomer(@PathVariable("id") Long id,@RequestBody CustomerRequestDto requestDto){
       HashMap<String,Object> map= new LinkedHashMap<String,Object>();
       try {
           CustomerRequestDto customerRequestDto = customerService.editCustomer(id,requestDto);


               CustomerRequestDto editedcustomerRequest = customerService.editCustomer(id,requestDto);
               map.put("status",1);
               map.put("data",editedcustomerRequest);
               return new ResponseEntity<>(map,HttpStatus.OK);


       } catch (CustomerNotException e) {
           map.clear();
           map.put("status",1);
           map.put("data","Client Not existe");
           return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);

       }


    }
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
       HashMap<String,Object> map= new LinkedHashMap<String,Object>();
       try {
            customerService.deleteCustomer(id);
            map.put("status",1);
            map.put("data","Le Client a ète Supprimeè avec Success");
            return new ResponseEntity<>(map,HttpStatus.OK);
       }catch (CustomerNotException customerNotException){
           map.clear();
           map.put("status",0);
           map.put("data","Aucun Client trouve");
           return  new ResponseEntity<>(map, HttpStatus.OK);

       }


    }
}
