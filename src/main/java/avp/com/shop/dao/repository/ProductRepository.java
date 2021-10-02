package avp.com.shop.dao.repository;

import avp.com.shop.beans.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional
    @Query(value = "SELECT pp.url FROM ProductPhoto pp INNER JOIN Product p ON pp.product.id=p.id WHERE p.id=?1")
    String findProductsPhotoById(Long id);
}
