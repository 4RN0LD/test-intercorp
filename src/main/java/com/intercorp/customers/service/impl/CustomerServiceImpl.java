package com.intercorp.customers.service.impl;

import com.intercorp.customers.model.Customer;
import com.intercorp.customers.repository.CustomerRepo;
import com.intercorp.customers.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepo repo;

    @Override
    public Customer create(Customer customer) {
        return repo.save(customer);
    }

    @Override
    public List<Customer> findByOptionalDniOrEmail(String dni, String email) {
        if (dni == null && email == null) {
            return repo.findAll();
        } else if (dni == null) {
            return repo.findByEmailContains(email);
        } else if (email == null) {
            return repo.findByDniContains(dni);
        }
        return repo.findDistinctByDniContainsAndEmailContains(dni, email);
    }
}
