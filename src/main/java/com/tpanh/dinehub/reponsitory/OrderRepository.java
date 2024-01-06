package com.tpanh.dinehub.reponsitory;

import com.tpanh.dinehub.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}