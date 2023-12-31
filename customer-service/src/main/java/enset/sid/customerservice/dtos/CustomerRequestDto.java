package enset.sid.customerservice.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class CustomerRequestDto {
    private  String firstName;
    private  String lastName;
    private String email;
    private String picture;
    private  int age;
    private String gender;
    private String phone;
    private String address;
}
