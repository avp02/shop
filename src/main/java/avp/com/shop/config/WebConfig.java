package avp.com.shop.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import javax.servlet.Filter;

@Configuration
public class WebConfig {

//    @Bean
//    public Filter shallowEtagHeaderFilter() {
//        return new ShallowEtagHeaderFilter();
//    }
//    @Bean
//    public FilterRegistrationBean customerFilterRegistrationBean() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setName("greeting");
//        CustomerFilter customerFilter = new CustomerFilter();
//        registrationBean.setFilter(customerFilter);
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }

//    @Bean
//    public FilterRegistrationBean helloFilterRegistrationBean() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setName("hello");
//        HelloFilter helloFilter = new HelloFilter();
//        registrationBean.setFilter(helloFilter);
//        registrationBean.setOrder(2);
//        return registrationBean;
//    }
}
