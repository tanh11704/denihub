package com.tpanh.dinehub.entity;

import com.tpanh.dinehub.entity.key.KeyCartItem;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cart_items")
public class CartItem extends BaseEntity {
    @EmbeddedId
    private KeyCartItem id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false, insertable = false, updatable = false)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", nullable = false, insertable = false, updatable = false)
    private Food food;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}