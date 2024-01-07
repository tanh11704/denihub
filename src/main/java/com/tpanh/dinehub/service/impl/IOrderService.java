package com.tpanh.dinehub.service.impl;

import com.tpanh.dinehub.dto.OrderDTO;
import com.tpanh.dinehub.entity.Order;
import com.tpanh.dinehub.exception.DataNotFoundException;

import java.util.List;

public interface IOrderService {
    Order createOrder(OrderDTO order) throws Exception;
    Order getOrder(Integer id) throws Exception;
    Order updateOrder(Integer id, OrderDTO order) throws Exception;
    void deleteOrder(Integer id) throws Exception;
    List<Order> findByUserId(Integer userId);
}
