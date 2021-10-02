package avp.com.shop.dao.service;

import avp.com.shop.beans.Product;
import avp.com.shop.dao.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public String getProductsPhoto(Long id) {
        return productRepository.findProductsPhotoById(id);
    }
}
