package enst.sid.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long id;
    private  String firstName;
    private  String lastName;
    private String email;
    private String picture;
    private  int age;
    private String gender;
    private String phone;
    private String address;
}
