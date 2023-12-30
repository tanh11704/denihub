package com.tpanh.dinehub.reponsitory;

import com.tpanh.dinehub.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}