package enst.sid.accountservice.service;

import enst.sid.accountservice.dtos.AccountRequestDto;
import enst.sid.accountservice.dtos.AccountResponseDto;
import enst.sid.accountservice.entities.Account;
import enst.sid.accountservice.exception.AccountNotFoundException;

import java.util.List;

public interface AccountService {
    List<AccountResponseDto> getAllAccount();
    AccountResponseDto getAccountById(Long id) throws AccountNotFoundException;
    AccountRequestDto addAccount(AccountRequestDto accountRequestDto);

}
