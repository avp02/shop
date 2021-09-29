package avp.com.shop.controllers;

import avp.com.shop.dao.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping()
    public ModelAndView allCustomers() {
        ModelAndView modelAndView = new ModelAndView("shop/customers/customers");
        modelAndView.addObject("customers", customerService.findAllCustomers());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView findCustomerById(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("shop/customers/customer");
        modelAndView.addObject("customer", customerService.findCustomerById(id));
        return modelAndView;
    }
}
