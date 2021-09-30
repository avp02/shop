package avp.com.shop.dao.repository;

import avp.com.shop.beans.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Transactional
    @Query(value = "select p.name from ProductCart pc inner join Product p on pc.product_id=p.id where pc.carts_id=?1")
    List<String> findAllProductNamesForCartById(Long id);

    @Transactional
    @Query(value = "select c.userName from Customer c inner join Cart ca on c.id=ca.customer.id where c.id=?1")
    String findUserNameCustomerById(Long id);

}
