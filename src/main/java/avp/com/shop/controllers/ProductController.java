package avp.com.shop.controllers;

import avp.com.shop.dao.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/shop/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public ModelAndView showAllProducts() {
        var modelAndView = new ModelAndView("shop/products/products");
        modelAndView.addObject("products", productService.findAllProducts());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getProductsPhoto(@PathVariable(name = "id") Long id) {
        var modelAndView = new ModelAndView("/shop/products/showPhoto");
        modelAndView.addObject("photo", productService.getProductsPhoto(id));
        return modelAndView;
    }
}
