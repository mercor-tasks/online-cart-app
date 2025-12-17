package com.example.online_cart_app.models.dtos;

import lombok.Data;

@Data
public class AddItemToCartRequest {
    private String customerId;
    private String inventoryItemId;
    private Integer requestedQty;
}
