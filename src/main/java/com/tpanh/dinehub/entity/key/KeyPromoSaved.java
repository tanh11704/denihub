package com.tpanh.dinehub.entity.key;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KeyPromoSaved implements Serializable {
    @Column(name = "promo_id", nullable = false)
    private Integer promoId;

    @Column(name = "user_id", nullable = false)
    private Integer savedId;
}
