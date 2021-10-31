package com.intercorp.customers.controller;

import com.intercorp.customers.model.Customer;
import com.intercorp.customers.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping
    public Object create(@RequestBody Customer customer) {
        customerService.create(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity findCustomers(String dni, String email) {
        List<Customer> customers = customerService.findByOptionalDniOrEmail(dni, email);
        return new ResponseEntity(customers, HttpStatus.OK);
    }


}
