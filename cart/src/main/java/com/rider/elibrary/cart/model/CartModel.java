package com.rider.elibrary.cart.model;

import com.rider.elibrary.cart.api.response.ItemInfoResponse;
import com.rider.elibrary.cart.entity.Cart;
import com.rider.elibrary.cart.entity.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartModel {

    private String id;
    private String userId;
    private List<CartItemModel> items;

    public static CartModel from(Cart cart, List<ItemInfoResponse> itemsInfo) {
        CartModel cartModel = new CartModel();
        cartModel.setId(cart.getId());
        cartModel.setUserId(cart.getUserId());
        List<CartItemModel> itemModels = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            for (ItemInfoResponse itemInfo : itemsInfo) {
                if (item.getProductId().equals(itemInfo.getId())) {
                    itemModels.add(CartItemModel.from(item, itemInfo));
                }
            }
        }
        cartModel.setItems(itemModels);
        return cartModel;
    }
}
