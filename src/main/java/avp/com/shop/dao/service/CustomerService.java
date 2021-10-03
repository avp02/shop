package avp.com.shop.dao.service;

import avp.com.shop.beans.Customer;
import avp.com.shop.dao.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Iterable<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Long id, String name, String userName, String phone, String email) {
        customerRepository.updateCustomer(id, name, userName, phone, email);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteCustomer(id);
    }
}
