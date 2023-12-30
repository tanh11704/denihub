package com.tpanh.dinehub.reponsitory;

import com.tpanh.dinehub.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}