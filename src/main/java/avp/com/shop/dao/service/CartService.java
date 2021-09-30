package avp.com.shop.dao.service;

import avp.com.shop.beans.Cart;
import avp.com.shop.beans.Customer;
import avp.com.shop.dao.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public List<Cart> findAllCart() {
        return cartRepository.findAll();
    }

    public Cart findCartById(Long id) {
        return cartRepository.findById(id).orElseThrow();
    }

    public List<String> findAllProductsForCustomerById(Long id) {
        return cartRepository.findAllProductNamesForCartById(id);
    }

    public String findUserNameCustomerById(Long id) {
        return cartRepository.findUserNameCustomerById(id);
    }
}
