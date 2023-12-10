package enset.sid.customerservice.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequestDto {

    private  String firstName;
    private  String lastName;
    private String email;
}
