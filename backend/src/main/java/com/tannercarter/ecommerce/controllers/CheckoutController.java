package com.tannercarter.ecommerce.controllers;

import com.tannercarter.ecommerce.services.CheckoutService;
import com.tannercarter.ecommerce.services.PurchaseData;
import com.tannercarter.ecommerce.services.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin("http://localhost:4200")
public class CheckoutController {
    private CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody PurchaseData purchaseData) {
        return checkoutService.checkout(purchaseData);
    }
}
