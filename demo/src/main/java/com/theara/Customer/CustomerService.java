package com.theara.Customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }
    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerByEmail = customerRepository.findCustomerByEmail(customer.getEmail());
        if(customerByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        customerRepository.save(customer);
        System.out.println(customer);
    }
    public void deleteCustomer(Long customerId) {
        boolean exists = customerRepository.existsById(customerId.intValue());
        if(!exists){
            throw new IllegalStateException("Student with id "+customerId+"dostnt not exitst");
        }
        customerRepository.deleteById(Math.toIntExact(customerId));
    }
}
