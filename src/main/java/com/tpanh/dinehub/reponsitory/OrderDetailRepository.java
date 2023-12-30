package com.tpanh.dinehub.reponsitory;

import com.tpanh.dinehub.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}