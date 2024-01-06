package com.tpanh.dinehub.entity.key;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KeyCartItem implements Serializable {
    @Column(name = "card_id", nullable = false)
    private Integer cartId;

    @Column(name = "food_id", nullable = false)
    private Integer foodId;
}
