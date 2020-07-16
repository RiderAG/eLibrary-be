package com.rider.elibrary.cart.service.impl;

import com.rider.elibrary.cart.api.CatalogApi;
import com.rider.elibrary.cart.api.response.ItemInfoResponse;
import com.rider.elibrary.cart.entity.Cart;
import com.rider.elibrary.cart.entity.CartItem;
import com.rider.elibrary.cart.model.CartModel;
import com.rider.elibrary.cart.repository.CartRepository;
import com.rider.elibrary.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CatalogApi catalogApi;

    @Override
    public CartModel getCurrentCartWithInfo(String userId) {
        Cart cart = getOrCreateCartByUserId(userId);
        List<ItemInfoResponse> itemsInfo = null;
        if (Objects.nonNull(cart.getItems()) && !cart.getItems().isEmpty()) {
            List<String> productIds = cart.getItems().stream()
                    .map(CartItem::getProductId)
                    .collect(Collectors.toList());
            itemsInfo = catalogApi.productsByIds(productIds);
        }
        return CartModel.from(cart, itemsInfo);
    }

    @Override
    public Cart addToCart(String userId, String productId) {
        Cart cart = getOrCreateCartByUserId(userId);
        Optional<CartItem> cartItem = cart.getItems().stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst();
        if (cartItem.isPresent()) {
            CartItem item = cartItem.get();
            item.setQuantity(item.getQuantity() + 1);
        } else {
            cart.getItems().add(new CartItem(null, productId, 1));
        }
        return cartRepository.save(cart);
    }

    @Override
    public CartModel updateItemCount(String userId, String itemId, Integer quantity) {
        Cart cart = getOrCreateCartByUserId(userId);
        List<CartItem> items = cart.getItems();
        for (CartItem item : items) {
            if (item.getId().equals(itemId)) {
                item.setQuantity(quantity);
                break;
            }
        }
        cartRepository.save(cart);
        return getCurrentCartWithInfo(userId);
    }

    private Cart getOrCreateCartByUserId(String userId) {
        return cartRepository.findByUserId(userId)
                .orElseGet(() -> createNewCart(userId));
    }

    private Cart createNewCart(String userId) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setItems(new ArrayList<>());
        return cartRepository.save(cart);
    }

}
