package enst.sid.accountservice.service;

import enst.sid.accountservice.dao.AccountRepository;
import enst.sid.accountservice.dtos.AccountRequestDto;
import enst.sid.accountservice.dtos.AccountResponseDto;
import enst.sid.accountservice.entities.Account;
import enst.sid.accountservice.enums.AccountType;
import enst.sid.accountservice.exception.AccountNotFoundException;
import enst.sid.accountservice.mapper.AccountMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AccountMapper accountMapper;
    private AccountRepository accountRepository;
    /**
     * @return
     */
    @Override
    public List<AccountResponseDto> getAllAccount() {
        List<Account> accounts= accountRepository.findAll();
        return accounts.stream().map(account->accountMapper.fromAccountToAccountResponseDto(account)).toList();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public AccountResponseDto getAccountById(Long id) throws AccountNotFoundException {

        return null;
    }

    /**
     * @param accountRequestDto
     * @return
     */
    @Override
    public AccountRequestDto addAccount(AccountRequestDto accountRequestDto) {
        Account account = accountMapper.fromAccountRequestDtoToAccount(accountRequestDto);
        account.setAccountId(UUID.randomUUID().toString());
        account.setCreateAt(LocalDate.now());
        account.setType(AccountType.CREATED);
        Account savedAccount=accountRepository.save(account);
        return accountMapper.fromAccountToAccountRequestDto(savedAccount) ;
    }
}
