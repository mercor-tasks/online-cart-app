package com.example.online_cart_app.repos;

import com.example.online_cart_app.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, String> {
}
