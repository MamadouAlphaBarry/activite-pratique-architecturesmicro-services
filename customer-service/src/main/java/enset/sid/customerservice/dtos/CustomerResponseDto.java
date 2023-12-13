package enset.sid.customerservice.dtos;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class CustomerResponseDto {
    private  Long id;
    private  String firstName;
    private  String lastName;
    private String email;
    private String picture;
    private  int age;
    private String gender;
    private String phone;
    private String address;
}
