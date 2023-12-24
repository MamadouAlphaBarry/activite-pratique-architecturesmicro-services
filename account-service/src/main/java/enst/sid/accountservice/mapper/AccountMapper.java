package enst.sid.accountservice.mapper;

import enst.sid.accountservice.dtos.AccountRequestDto;
import enst.sid.accountservice.dtos.AccountResponseDto;
import enst.sid.accountservice.entities.Account;

public interface AccountMapper {
    Account fromAccountRequestDtoToAccount(AccountRequestDto accountRequestDto);
    AccountRequestDto fromAccountToAccountRequestDto(Account account);
    Account fromAccountResponseDtoToAccount(AccountResponseDto accountResponseDto);
    AccountResponseDto fromAccountToAccountResponseDto(Account account);
}
