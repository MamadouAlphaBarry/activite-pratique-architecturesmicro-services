package enset.sid.customerservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String firstName;
    private  String lastName;
    private String email;
    private String picture;
    private  int age;
    private String gender;
    private String phone;
    private String address;

    /**
     *   firstName: '{{firstName()}}',
     *     lastName: '{{surname()}}',
     *     email: '{{email()}}',
     *     picture: 'http://placehold.it/32x32',
     *     age: '{{integer(20, 40)}}',
     *    //eyeColor: '{{random("blue", "brown", "green")}}',
     *    // name: '{{firstName()}} {{surname()}}',
     *     gender: '{{gender()}}',
     *
     *     phone: '+1 {{phone()}}',
     *     address: '{{integer(100, 999)}} {{street()}}, {{city()}}, {{state()}}, {{integer(100,
     * */
}
