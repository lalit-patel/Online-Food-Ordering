package com.patel.service;

import com.patel.model.Cart;
import com.patel.model.CartItem;
import com.patel.model.Order;
import com.patel.request.AddToCartItemRequest;

public interface CartService {

    public CartItem addItemToCart(AddToCartItemRequest req, String jwt) throws Exception;

    public CartItem updateCartItemQuantity(Long cartItemId, int quantity) throws Exception;

    public Cart removeItemFromCart(Long cartItemId, String jwt) throws Exception;

    public Long calculateCartTotal(Cart cart) throws Exception;

    public Cart findCartById(Long id) throws Exception;

    public Cart findCartByUserId(Long userId) throws Exception;

    public Cart clearCart(Long userId) throws Exception;

}
