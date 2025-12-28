package com.tannercarter.ecommerce.validation;

import com.tannercarter.ecommerce.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Customer.class)
@RequiredArgsConstructor
public class CustomerEventHandler {

    private final CustomerValidator validator;

    @HandleBeforeCreate
    public void beforeCreate(Customer customer) {
        validator.validateForCreate(customer);
    }
}