package com.rider.elibrary.cart.model;

import com.rider.elibrary.cart.api.response.ItemInfoResponse;
import com.rider.elibrary.cart.entity.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemModel {

    private String id;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public static CartItemModel from(CartItem item, ItemInfoResponse itemInfo) {
        CartItemModel cartItemModel = new CartItemModel();
        cartItemModel.setId(item.getId());
        cartItemModel.setName(itemInfo.getName());
        cartItemModel.setPrice(itemInfo.getPrice());
        cartItemModel.setQuantity(item.getQuantity());
        return cartItemModel;
    }
}
