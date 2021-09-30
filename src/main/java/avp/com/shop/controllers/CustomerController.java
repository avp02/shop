package avp.com.shop.controllers;

import avp.com.shop.beans.Customer;
import avp.com.shop.dao.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

//    @GetMapping("/new")
//    public ModelAndView createFormForNewCustomer() {
//        ModelAndView modelAndView = new ModelAndView("shop/customers/new");
//        modelAndView.addObject("customer", new Customer());
//        return modelAndView;
//    }

    @GetMapping("/new")
    public ModelAndView createFormForNewCustomer(@ModelAttribute("customer") Customer customer) {
        ModelAndView modelAndView = new ModelAndView("shop/customers/new");
        return modelAndView;
    }

    @PostMapping()
    public ModelAndView createNewCustomer(@ModelAttribute(name = "Customer") Customer customer) {
        customerService.saveCustomer(customer);
        ModelAndView modelAndView = new ModelAndView("redirect:/shop/customers");
        return modelAndView;
    }
}
