package com.patel.repository;

import com.patel.model.Cart;
import com.patel.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


}
