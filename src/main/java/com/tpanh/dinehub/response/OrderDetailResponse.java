package com.tpanh.dinehub.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tpanh.dinehub.entity.OrderDetail;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({"id", "order_id", "food_id", "quantity", "total_money"})
public class OrderDetailResponse {
    private Integer id;
    @JsonProperty("order_id")
    private Integer orderId;
    @JsonProperty("food_id")
    private Integer foodId;
    private Integer quantity;
    @JsonProperty("total_money")
    private Double totalMoney;

    public static OrderDetailResponse fromOrderDetail(OrderDetail orderDetail) {
        return OrderDetailResponse
                .builder()
                .id(orderDetail.getId())
                .foodId(orderDetail.getFood().getId())
                .orderId(orderDetail.getOrder().getId())
                .quantity(orderDetail.getQuantity())
                .totalMoney(orderDetail.getTotalMoney())
                .build();
    }
}
