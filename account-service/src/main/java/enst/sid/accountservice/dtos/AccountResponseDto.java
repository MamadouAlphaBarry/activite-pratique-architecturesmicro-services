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
public class AccountResponseDto {
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;

    private AccountType type;

    private Customer customer;
    private Long customerId;
}
