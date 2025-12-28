package com.tannercarter.ecommerce.dao;

import com.tannercarter.ecommerce.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}
