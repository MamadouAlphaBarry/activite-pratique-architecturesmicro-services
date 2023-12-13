package enset.sid.customerservice.dao;

import enset.sid.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer ,Long> {
    @Query("select c from Customer c where(c.firstName like :kw)"+
            "Or (c.lastName like :kw) Or (c.email like: kw)"
    )
    List<Customer> searchCustomers(@Param("kw") String kw);

   @Query("select  case when count(c)>0 then  true else  false END FROM  Customer c where  c.email=?1")
    Boolean checkIfEmailExist(String email);

    List<Customer> findByFirstNameContains(String fn);
    List<Customer>findByFirstNameContainsOrLastNameContains(String fn,String ln);
}
