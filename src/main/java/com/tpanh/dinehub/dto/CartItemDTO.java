package com.tpanh.dinehub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
    @JsonProperty("cart_id")
    private Integer cartId;

    @JsonProperty("food_id")
    private Integer foodId;

    private Integer quantity;
}
