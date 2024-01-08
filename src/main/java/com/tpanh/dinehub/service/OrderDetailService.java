package com.tpanh.dinehub.service;

import com.tpanh.dinehub.dto.OrderDetailDTO;
import com.tpanh.dinehub.entity.Food;
import com.tpanh.dinehub.entity.Order;
import com.tpanh.dinehub.entity.OrderDetail;
import com.tpanh.dinehub.exception.DataNotFoundException;
import com.tpanh.dinehub.reponsitory.FoodRepository;
import com.tpanh.dinehub.reponsitory.OrderDetailRepository;
import com.tpanh.dinehub.reponsitory.OrderRepository;
import com.tpanh.dinehub.service.impl.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    FoodRepository foodRepository;

    @Override
    public OrderDetail createOrderDetail(OrderDetailDTO orderDetail) throws Exception {
        Order order = orderRepository.findById(orderDetail.getOrderId())
                .orElseThrow(() -> new DataNotFoundException(
                        "Cannot find Order with id : "+orderDetail.getOrderId()));
        Food food = foodRepository.findById(orderDetail.getFoodId())
                .orElseThrow(() -> new DataNotFoundException(
                        "Cannot find product with id: " + orderDetail.getFoodId()));
        OrderDetail newOrderDetail = new OrderDetail()
                .builder()
                .order(order)
                .food(food)
                .quantity(orderDetail.getQuantity())
                .totalMoney(orderDetail.getTotalMoney())
                .build();
        return orderDetailRepository.save(newOrderDetail);
    }

    @Override
    public OrderDetail updateOrderDetail(Integer id, OrderDetailDTO orderDetail) throws Exception {
        OrderDetail orderDetailToUpdate = orderDetailRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(
                        "Cannot find OrderDetail with id : "+id));
        Order order = orderRepository.findById(orderDetail.getOrderId())
                .orElseThrow(() -> new DataNotFoundException(
                        "Cannot find Order with id : "+orderDetail.getOrderId()));
        Food food = foodRepository.findById(orderDetail.getFoodId())
                .orElseThrow(() -> new DataNotFoundException(
                        "Cannot find product with id: " + orderDetail.getFoodId()));
        orderDetailToUpdate.setOrder(order);
        orderDetailToUpdate.setFood(food);
        orderDetailToUpdate.setQuantity(orderDetail.getQuantity());
        orderDetailToUpdate.setTotalMoney(orderDetail.getTotalMoney());
        return orderDetailRepository.save(orderDetailToUpdate);
    }

    @Override
    public void deleteById(Integer id) {
        orderDetailRepository.deleteById(id);
    }

    @Override
    public List<OrderDetail> findByOrderId(Integer orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }
}
