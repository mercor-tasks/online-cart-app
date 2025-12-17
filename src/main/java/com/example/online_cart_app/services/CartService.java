package com.example.online_cart_app.services;


import com.example.online_cart_app.models.Cart;
import com.example.online_cart_app.models.CartItem;
import com.example.online_cart_app.models.Customer;
import com.example.online_cart_app.models.dtos.AddItemToCartRequest;
import com.example.online_cart_app.repos.CartItemRepo;
import com.example.online_cart_app.repos.CartRepo;
import com.example.online_cart_app.repos.CustomerRepo;
import com.example.online_cart_app.repos.InventoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class CartService {
    private CustomerRepo customerRepo;
    private CartRepo cartRepo;
    private CartItemRepo cartItemRepo;
    private InventoryRepo inventoryRepo;

    public CartService(CustomerRepo customerRepo,
                       CartRepo cartRepo,
                       CartItemRepo cartItemRepo,
                       InventoryRepo inventoryRepo) {
        this.customerRepo = customerRepo;
        this.cartRepo = cartRepo;
        this.cartItemRepo = cartItemRepo;
        this.inventoryRepo = inventoryRepo;
    }

    public CartItem addItemToCart(AddItemToCartRequest addItemToCartRequest) {
        String customerId = addItemToCartRequest.getCustomerId();
        String inventoryItemId = addItemToCartRequest.getInventoryItemId();
        Integer reqQty = addItemToCartRequest.getRequestedQty();

        Customer customer = customerRepo.getReferenceById(customerId);
        String cartId = customer.getCartId();
        Cart cart = cartRepo.getReferenceById(cartId);

        CartItem cartItem = createCartItem(inventoryItemId, reqQty);

        cart.getCartItemIds().add(cartItem.getItemId());

        cartItemRepo.save(cartItem);
        cartRepo.save(cart);

        return cartItem;
    }

    private static CartItem createCartItem(String inventoryItemId, Integer reqQty) {
        CartItem cartItem = new CartItem();
        cartItem.setItemId(UUID.randomUUID().toString());
        cartItem.setInventoryItemId(inventoryItemId);
        cartItem.setQty(reqQty);
        return cartItem;
    }
}
