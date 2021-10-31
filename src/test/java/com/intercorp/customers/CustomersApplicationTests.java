package com.intercorp.customers;

import com.intercorp.customers.model.Customer;
import com.intercorp.customers.service.ICustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;

@SpringBootTest
class CustomersApplicationTests {

    @Autowired
    private ICustomerService customerService;

    @Test
    void contextLoads() {
    }

    @Test
    void createCustomerOk(){
        Customer customer = new Customer();
        customer.setBirthDate(LocalDate.now());
        customer.setDni("12345678");
        customer.setEmail("prueba@intercorp.com");
        customer.setName("Luis");
        customer.setSurname("Rosas");
        Customer customer1 = customerService.create(customer);
        Assert.notNull(customer1);
    }

}
