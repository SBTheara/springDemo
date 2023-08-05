package com.theara.Customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CustomerConfig {
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository){
        return args -> {
            Customer cus= new Customer(1L,"Theara","email.com", LocalDate.of(2001, Month.JANUARY,25),"Phnom penh");
            Customer cus1= new Customer(2L,"Theara","email.com",LocalDate.of(2002, Month.FEBRUARY,15),"Phnom penh");
            Customer cus2= new Customer(3L,"Theara","email.com",LocalDate.of(1999, Month.APRIL,11),"Phnom penh");
            repository.saveAll(List.of(cus,cus1,cus2));
        };
    }
}
