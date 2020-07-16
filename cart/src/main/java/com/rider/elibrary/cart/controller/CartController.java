package com.rider.elibrary.cart.controller;

import com.rider.elibrary.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private static final String USER_ID_CLAIM = "user_id";

    @Autowired
    private CartService cartService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity currentCart(@AuthenticationPrincipal Jwt jwt) {
        String userId = extractUserIdFromJwt(jwt);
        return ResponseEntity.ok(cartService.getCurrentCartWithInfo(userId));
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity addToCart(@AuthenticationPrincipal Jwt jwt, @RequestParam("id") String productId) {
        String userId = extractUserIdFromJwt(jwt);
        return ResponseEntity.ok(cartService.addToCart(userId, productId));
    }

    @PutMapping("/items/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity updateItemCount(@AuthenticationPrincipal Jwt jwt,
                                          @PathVariable("itemId") String itemId,
                                          @RequestParam("quantity") Integer quantity) {
        String userId = extractUserIdFromJwt(jwt);
        return ResponseEntity.ok(cartService.updateItemCount(userId, itemId, quantity));
    }

    private String extractUserIdFromJwt(Jwt jwt) {
        return jwt.getClaim(USER_ID_CLAIM);
    }

}
