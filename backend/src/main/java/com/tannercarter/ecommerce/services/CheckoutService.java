package com.tannercarter.ecommerce.services;

public interface CheckoutService {

    PurchaseResponse checkout(PurchaseData purchaseData);
}
