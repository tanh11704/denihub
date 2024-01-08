package com.tpanh.dinehub.service;

import com.tpanh.dinehub.dto.OrderDetailDTO;
import com.tpanh.dinehub.entity.OrderDetail;
import com.tpanh.dinehub.service.impl.IOrderDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Override
    public OrderDetail createOrderDetail(OrderDetailDTO orderDetail) throws Exception {
        return null;
    }

    @Override
    public OrderDetail updateOrderDetail(Integer id, OrderDetailDTO orderDetail) throws Exception {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<OrderDetail> findByOrderId(Integer orderId) {
        return null;
    }
}
