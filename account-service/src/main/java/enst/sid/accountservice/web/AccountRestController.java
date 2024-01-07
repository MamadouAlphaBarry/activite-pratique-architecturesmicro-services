package enst.sid.accountservice.web;

import enst.sid.accountservice.client.CustomerClientMapper;
import enst.sid.accountservice.client.CustomerResponseDto;
import enst.sid.accountservice.client.CustomerRestClient;
import enst.sid.accountservice.dtos.AccountRequestDto;
import enst.sid.accountservice.dtos.AccountResponseDto;
import enst.sid.accountservice.entities.Account;
import enst.sid.accountservice.model.Customer;
import enst.sid.accountservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class AccountRestController {
    private AccountService accountService;
    private CustomerRestClient customerRestClient;
    private CustomerClientMapper customerClientMapper;
    
    @PostMapping("/accounts")
    public ResponseEntity<?> saveAccount(@RequestBody AccountRequestDto accountRequestDto)
    {
        HashMap<String,Object> map= new LinkedHashMap<String,Object>();
        try {
            AccountRequestDto accountRequestDto1 = accountService.addAccount(accountRequestDto);
            map.put("status",1);
            map.put("data",accountRequestDto1);
            return new ResponseEntity<>(map,HttpStatus.CREATED);

        }catch (Exception e){
            map.clear();
            map.put("status",0);

            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/accounts")
    ResponseEntity<?> getAllAccount(){
        HashMap<String,Object> map= new LinkedHashMap<String, Object>();

            List<AccountResponseDto> allAccount = accountService.getAllAccount();

            if (!allAccount.isEmpty()){
                List<AccountResponseDto> accountResponseDtoList= new ArrayList<>();


               // allAccount.stream().map(accountResponseDto -> customerRestClient.findCustomerById(accountResponseDto.getCustomerId())).collect(Collectors.toList());
                for (AccountResponseDto accountResponseDto:allAccount) {
                    ResponseEntity<?> customerById = customerRestClient.findCustomerById(accountResponseDto.getCustomerId());
                    Map<String, Object> body = (Map<String, Object>) customerById.getBody();
                    CustomerResponseDto o= (CustomerResponseDto) body.get("data");
                    Customer customer =new Customer();
                    customer.setLastName(o.getLastName());
                    accountResponseDto.setCustomer(customer);
                   // map.put("object",o);
                   // CustomerResponseDto customer= (CustomerResponseDto) body.get("data");
                   // accountResponseDto.setCustomer(customerClientMapper.fromCustomerToCustomerResponseDto(customer));
                    accountResponseDtoList.add(accountResponseDto);
                }
                map.put("status",1);

                map.put("data",accountResponseDtoList);
                return  new ResponseEntity<>(map,HttpStatus.OK);
            }else {
                map.clear();
                map.put("status",0);
                map.put("data","Aucun Account Trouvè");
                return  new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
            }




    }
    
}
