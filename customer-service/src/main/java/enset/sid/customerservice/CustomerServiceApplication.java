package enset.sid.customerservice;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import enset.sid.customerservice.dtos.CustomerRequestDto;
import enset.sid.customerservice.dtos.CustomerResponseDto;
import enset.sid.customerservice.entities.Customer;
import enset.sid.customerservice.mappers.CustomerMapper;
import enset.sid.customerservice.service.CustomerService;
import enset.sid.customerservice.web.CustomerRestController;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class CustomerServiceApplication {
private CustomerMapper customerMapper;
private CustomerService service;
private CustomerRestController controller;
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);




    }
    @Bean
    CommandLineRunner commandLineRunner(){
      return args -> {
          // Create an ObjectMapper instance
          ObjectMapper objectMapper = new ObjectMapper();

          try {
              // Load the customers.json file from the classpath
              ClassPathResource resource = new ClassPathResource("static/customers.json");
              File file = resource.getFile();

              // Read JSON from file and map it to a List of Customer objects
              List<Customer> customerList = objectMapper.readValue(file, new TypeReference<List<Customer>>() {});

              // Now 'customerList' contains the data from the JSON file
              for (Customer customer : customerList) {
                  CustomerResponseDto customerResponseDto = this.customerMapper.fromCustomerToCustomerResponseDto(customer);
                  CustomerRequestDto requestDto= this.customerMapper.fromCustomerToCustomerRequestDto(customer);
                  controller.saveNewCustomer(requestDto);
                  //System.out.println("Customer: " + customer);
                //  System.out.println("CustomerResponse:**** " + customerResponseDto);
              }
          } catch (IOException e) {
              e.printStackTrace();
          }


      } ;
    }

}
