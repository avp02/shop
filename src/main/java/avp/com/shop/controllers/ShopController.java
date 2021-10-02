package avp.com.shop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @GetMapping()
    public ModelAndView showShop() {
        var modelAndView = new ModelAndView("/shop/showShop");
        return modelAndView;
    }
}
