package avp.com.shop.controllers;

import avp.com.shop.beans.Customer;
import avp.com.shop.dao.service.CartService;
import avp.com.shop.dao.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop/carts")
public class CartController {

    private final CartService cartService;
    private final CustomerService customerService;

//    @GetMapping("/{id}")
//    public ModelAndView showCartById(@PathVariable(name = "id") Long id) {
//        ModelAndView modelAndView = new ModelAndView("shop/carts/cart");
//        modelAndView.addObject("cart", cartService.findCartById(id));
//        return modelAndView;
//    }

    @GetMapping("/{id}")
    public ModelAndView findAllProductNamesForCartById(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView =new ModelAndView("/shop/carts/cart");
        modelAndView.addObject("productNames", cartService.findAllProductsForCustomerById(id));
        modelAndView.addObject("userNameCustomer", cartService.findUserNameCustomerById(id));
        modelAndView.addObject("customer", customerService.findCustomerById(id));
        return modelAndView;
    }

//    @GetMapping("/{id}")
//    public ModelAndView findCustomerById(@PathVariable(name = "id") Long id) {
//        ModelAndView modelAndView = new ModelAndView("shop/carts/cart");
//        modelAndView.addObject("customer", customerService.findCustomerById(id));
//        return modelAndView;
//    }

//    @GetMapping("/{id}")
//    public ModelAndView findUserNameCustomerById(@PathVariable(name = "id") Long id) {
//        ModelAndView modelAndView = new ModelAndView("shop/carts/cart");
//        modelAndView.addObject("userNameCustomer", cartService.findUserNameCustomerById(id));
//        return modelAndView;
//    }


}
