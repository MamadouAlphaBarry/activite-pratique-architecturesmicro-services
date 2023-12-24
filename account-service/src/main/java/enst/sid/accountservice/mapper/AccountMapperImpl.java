package enst.sid.accountservice.mapper;

import enst.sid.accountservice.dtos.AccountRequestDto;
import enst.sid.accountservice.dtos.AccountResponseDto;
import enst.sid.accountservice.entities.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountMapperImpl implements AccountMapper {
    /**
     * @param accountRequestDto
     * @return
     */
    @Override
    public Account fromAccountRequestDtoToAccount(AccountRequestDto accountRequestDto) {
        Account account= Account.builder()
                .type(accountRequestDto.getType())
                .balance(accountRequestDto.getBalance())
                .currency(accountRequestDto.getCurrency())
                .customer(accountRequestDto.getCustomer())
                .customerId(accountRequestDto.getCustomerId())
                .build();
        return account;
    }

    /**
     * @param account
     * @return
     */
    @Override
    public AccountRequestDto fromAccountToAccountRequestDto(Account account) {
        AccountRequestDto accountRequestDto= AccountRequestDto.builder().build();
        return accountRequestDto;
    }

    /**
     * @param accountResponseDto
     * @return
     */
    @Override
    public Account fromAccountResponseDtoToAccount(AccountResponseDto accountResponseDto) {
        Account account = Account.builder().build();
        return account;
    }

    /**
     * @param account
     * @return
     */
    @Override
    public AccountResponseDto fromAccountToAccountResponseDto(Account account) {
        AccountResponseDto accountResponseDto= AccountResponseDto.builder()
                .accountId(account.getAccountId())
                .balance(account.getBalance())
                .customer(account.getCustomer())
                .type(account.getType())
                .createAt(account.getCreateAt())
                .currency(account.getCurrency())
                .customerId(account.getCustomerId())
                .build();

        return accountResponseDto;
    }
}
