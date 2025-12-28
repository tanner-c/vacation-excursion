package com.tannercarter.ecommerce.services;

import com.tannercarter.ecommerce.entities.Cart;
import com.tannercarter.ecommerce.entities.CartItem;
import com.tannercarter.ecommerce.entities.Customer;
import lombok.Data;

import java.util.Set;

@Data
public class PurchaseData {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
