package com.tannercarter.ecommerce.dao;

import com.tannercarter.ecommerce.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
