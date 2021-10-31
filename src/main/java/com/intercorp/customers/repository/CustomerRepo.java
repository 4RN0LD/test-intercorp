package com.intercorp.customers.repository;

import com.intercorp.customers.dto.QuantityByMonthDTO;
import com.intercorp.customers.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, UUID> {

    List<Customer> findByDniContains(String dni);

    List<Customer> findByEmailContains(String email);

    List<Customer> findDistinctByDniContainsAndEmailContains(String dni, String email);

    @Query(value = "SELECT CONCAT(MONTH(fecha_nacimiento),'/', YEAR(fecha_nacimiento)), COUNT(fecha_nacimiento) " +
            "FROM cliente " +
            "GROUP BY CONCAT(MONTH(fecha_nacimiento),'/', YEAR(fecha_nacimiento))", nativeQuery = true)
    List<Object[]> groupByBirthDate();
}
