package enst.sid.accountservice.dtos;

import enst.sid.accountservice.enums.AccountType;
import enst.sid.accountservice.model.Customer;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountRequestDto {

    private double balance;

    private String currency;

    private AccountType type;
    private Customer customer;
    private Long customerId;
}
