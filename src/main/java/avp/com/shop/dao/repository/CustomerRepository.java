package avp.com.shop.dao.repository;

import avp.com.shop.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    @Override
//    @Transactional
//    @Query(value = "select ")
//    void save(Customer customer);

    @Transactional
    @Modifying
    @Query(value = "UPDATE customers SET name=?2, user_name=?3, phone=?4, email=?5 WHERE id=?1", nativeQuery = true)
    void updateCustomer(Long id, String name, String userName, String phone, String email);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM customers WHERE id=?1", nativeQuery = true)
    void deleteCustomer(Long id);
}
