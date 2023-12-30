package com.tpanh.dinehub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {
//    private Integer id;
    @JsonProperty("order_id")
    private Integer orderId;
    @JsonProperty("food_id")
    private Integer foodId;
    private Integer quantity;
    @JsonProperty("total_money")
    private Float totalMoney;
//    @JsonProperty("updated_at")
//    private String updatedAt;
//    @JsonProperty("created_at")
//    private String createdAt;
}
