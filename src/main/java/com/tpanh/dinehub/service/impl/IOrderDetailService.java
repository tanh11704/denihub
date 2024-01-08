package com.tpanh.dinehub.service.impl;

import com.tpanh.dinehub.dto.OrderDetailDTO;
import com.tpanh.dinehub.entity.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
    OrderDetail createOrderDetail(OrderDetailDTO orderDetail) throws Exception;
    OrderDetail updateOrderDetail(Integer id, OrderDetailDTO orderDetail)
            throws Exception;
    void deleteById(Integer id);
    List<OrderDetail> findByOrderId(Integer orderId);
}
