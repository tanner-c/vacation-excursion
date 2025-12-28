package com.tannercarter.ecommerce.services;

import com.tannercarter.ecommerce.dao.CartItemRepository;
import com.tannercarter.ecommerce.dao.CartRepository;
import com.tannercarter.ecommerce.dao.CustomerRepository;
import com.tannercarter.ecommerce.entities.Cart;
import com.tannercarter.ecommerce.entities.CartItem;
import com.tannercarter.ecommerce.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository,
                               CartRepository cartRepository,
                               CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse checkout(PurchaseData purchaseData) {

        // Extract data from purchaseData
        Customer customer = purchaseData.getCustomer();
        Cart cart = purchaseData.getCart();
        Set<CartItem> cartItems = purchaseData.getCartItems();

        // Save customer
        customerRepository.save(customer);

        // Generate order tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // Set customer on cart
        cart.setCustomer(customer);

        // Save cart
        cartRepository.save(cart);

        // Save cart items
        for (CartItem cartItem : cartItems) {
            cartItem.setCart(cart);
            cartItemRepository.save(cartItem);
        }

        // Return response
        PurchaseResponse purchaseResponse = new PurchaseResponse();
        purchaseResponse.setOrderTrackingNumber(orderTrackingNumber);
        return purchaseResponse;
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
