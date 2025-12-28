package com.tannercarter.ecommerce.validation;

import java.util.List;

public class CustomerValidationException extends RuntimeException {
    private final List<String> errors;

    public CustomerValidationException(List<String> errors) {
        super("Customer validation failed");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}

