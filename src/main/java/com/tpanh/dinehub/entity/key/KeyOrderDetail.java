package com.tpanh.dinehub.entity.key;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KeyOrderDetail implements Serializable {
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "food_id", nullable = false)
    private Integer foodId;
}
