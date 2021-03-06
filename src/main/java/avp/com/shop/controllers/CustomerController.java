package avp.com.shop.controllers;

import avp.com.shop.beans.Customer;
import avp.com.shop.dao.service.CartService;
import avp.com.shop.dao.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop/customers")
public class CustomerController {

    private final CustomerService customerService;

    private final CartService cartService;

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

    @GetMapping("/new")
    public ModelAndView createFormForNewCustomer(@ModelAttribute("customer") Customer customer) {
        ModelAndView modelAndView = new ModelAndView("shop/customers/new");
        return modelAndView;
    }

    @PostMapping()
    public ModelAndView createNewCustomer(@ModelAttribute(name = "customer") @Valid Customer customer, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/shop/customers/new");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        customerService.saveCustomer(customer);
        cartService.saveCartOfCustomer(customer.getId());
        modelAndView.setViewName("redirect:/shop/customers");
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormForUpdateCustomer(@ModelAttribute("customer") Customer customer, @PathVariable(name = "id") Long id, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/shop/customers/edit");
        modelAndView.addObject("customer", customerService.findCustomerById(id));
        return modelAndView;
    }

    @PostMapping("/{id}")
    public ModelAndView updateCustomer(@PathVariable("id") Long id, @ModelAttribute(name = "customer") @Valid Customer customer, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/shop/customers/edit");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        customerService.updateCustomer(id, customer.getName(), customer.getUserName(), customer.getPhone(), customer.getEmail());
        modelAndView.setViewName("redirect:/shop/customers/{id}");
        return modelAndView;
    }

    @RequestMapping("/{id}/delete")
    public ModelAndView deleteCustomer(@PathVariable(name = "id") Long id) {
        customerService.deleteCustomer(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/shop/customers");
        return modelAndView;
    }
}
