package com.rider.elibrary.cart.service;

import com.rider.elibrary.cart.entity.Cart;
import com.rider.elibrary.cart.model.CartModel;

public interface CartService {

    CartModel getCurrentCartWithInfo(String userId);

    Cart addToCart(String userId, String productId);

    CartModel updateItemCount(String userId, String itemId, Integer count);
}
