package avp.com.shop.dao.service;

import avp.com.shop.beans.Cart;
import avp.com.shop.beans.Customer;
import avp.com.shop.beans.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CartServiceTest {

    @Autowired
    private CartService cartService;

    @Test
    void findAllProductsForCustomerById() {
        assertEquals(List.of(new Product(1L, "df", "fff", 343.0, List.of(new Cart(1L, new Customer(1L, "dsd", "dsda", "424", "adda"))))), cartService.findAllProductsForCustomerById(1L));
    }

    @Test
    void findUserNameCustomerById() {
        assertEquals("dsdas", cartService.findUserNameCustomerById(1L));
    }
}