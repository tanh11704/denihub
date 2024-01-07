package com.tpanh.dinehub.service;

import com.tpanh.dinehub.dto.OrderDTO;
import com.tpanh.dinehub.entity.Order;
import com.tpanh.dinehub.entity.OrderStatus;
import com.tpanh.dinehub.entity.User;
import com.tpanh.dinehub.exception.DataNotFoundException;
import com.tpanh.dinehub.reponsitory.OrderRepository;
import com.tpanh.dinehub.reponsitory.UserRepository;
import com.tpanh.dinehub.service.impl.IOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Order createOrder(OrderDTO order) throws Exception {

        User existedUser = userRepository.findById(order.getUserId())
                .orElseThrow(() -> new DataNotFoundException("User not found"));

        modelMapper.typeMap(OrderDTO.class, Order.class)
                .addMappings(mapper -> mapper.skip(Order::setId));
        Order newOrder = modelMapper.map(order, Order.class);
        newOrder.setUser(existedUser);
        newOrder.setStatus(OrderStatus.PENDING);
        return orderRepository.save(newOrder);
    }

    @Override
    public Order getOrder(Integer id) throws Exception {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Order not found"));
        return order;
    }

    @Override
    public Order updateOrder(Integer id, OrderDTO order) throws Exception {
        Order existedOrder = orderRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Order not found"));

        User existedUser = userRepository.findById(order.getUserId())
                .orElseThrow(() -> new DataNotFoundException("User not found"));

        modelMapper.typeMap(OrderDTO.class, Order.class)
                .addMappings(mapper -> mapper.skip(Order::setId));

        modelMapper.map(order, existedOrder);
        existedOrder.setUser(existedUser);
        return orderRepository.save(existedOrder);
    }

    @Override
    public Order deleteOrder(Integer id) throws Exception {
        Order existedOrder = orderRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Order not found"));
        existedOrder.setStatus(OrderStatus.CANCELLED);
        orderRepository.save(existedOrder);
        return existedOrder;
    }

    @Override
    public List<Order> findByUserId(Integer userId) {
        return orderRepository.findByUserId(userId);
    }
}
