package com.tannercarter.ecommerce.validation;

import com.tannercarter.ecommerce.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerValidator {

    public void validateForCreate(Customer c) {
        List<String> errors = new ArrayList<>();

        if (isBlank(c.getFirstName())) errors.add("firstName is required");
        if (isBlank(c.getLastName())) errors.add("lastName is required");
        if (isBlank(c.getAddress())) errors.add("address is required");
        if (isBlank(c.getPostalCode())) errors.add("postal_code is required");
        if (isBlank(c.getPhone())) errors.add("phone is required");


        if (!errors.isEmpty()) {
            throw new CustomerValidationException(errors);
        }
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}