package com.tpanh.dinehub.entity;

import com.tpanh.dinehub.entity.key.KeyPromoSaved;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "promo_saved")
public class PromoSaved extends BaseEntity {
    @EmbeddedId
    private KeyPromoSaved id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promo_id", nullable = false, insertable = false, updatable = false)
    private Promo promo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private User user;

}