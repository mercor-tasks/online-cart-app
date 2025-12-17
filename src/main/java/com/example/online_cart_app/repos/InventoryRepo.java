package com.example.online_cart_app.repos;

import com.example.online_cart_app.models.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<InventoryItem, String> {
}
