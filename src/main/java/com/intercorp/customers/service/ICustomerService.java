package com.intercorp.customers.service;

import com.intercorp.customers.model.Customer;

import java.util.List;

public interface ICustomerService {

    Customer create(Customer customer);

    List<Customer> findByOptionalDniOrEmail(String dni, String email);

}
