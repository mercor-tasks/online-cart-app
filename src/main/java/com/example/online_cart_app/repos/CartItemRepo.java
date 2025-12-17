package com.example.online_cart_app.repos;

import com.example.online_cart_app.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepo extends JpaRepository<CartItem, String> {
}
