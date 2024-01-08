package com.tpanh.dinehub.controller;

import com.tpanh.dinehub.dto.OrderDetailDTO;
import com.tpanh.dinehub.entity.OrderDetail;
import com.tpanh.dinehub.response.OrderDetailResponse;
import com.tpanh.dinehub.service.impl.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-details")
public class OrderDetailController {

    @Autowired
    IOrderDetailService orderDetailService;

    @PostMapping("")
    public ResponseEntity<OrderDetailResponse> createOrderDetail(@RequestBody OrderDetailDTO orderDetailDTO) throws Exception {
        OrderDetail newOrderDetail = orderDetailService.createOrderDetail(orderDetailDTO);
        return ResponseEntity.ok().body(OrderDetailResponse.fromOrderDetail(newOrderDetail));
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<List<OrderDetailResponse>> getOrderDetailByOrderId(@PathVariable Integer id) throws Exception {
        List<OrderDetail> orderDetails = orderDetailService.findByOrderId(id);
        List<OrderDetailResponse> orderDetailResponses = orderDetails.stream().map(
                OrderDetailResponse::fromOrderDetail
        ).toList();
        return ResponseEntity.ok().body(orderDetailResponses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetailResponse> updateOrderDetail(@PathVariable Integer id, @RequestBody OrderDetailDTO orderDetailDTO) throws Exception {
        OrderDetail updatedOrderDetail = orderDetailService.updateOrderDetail(id, orderDetailDTO);
        return ResponseEntity.ok().body(OrderDetailResponse.fromOrderDetail(updatedOrderDetail));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Integer id) throws Exception {
        orderDetailService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
