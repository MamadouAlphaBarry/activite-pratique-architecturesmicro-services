package enst.sid.accountservice.dao;

import enst.sid.accountservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

}
