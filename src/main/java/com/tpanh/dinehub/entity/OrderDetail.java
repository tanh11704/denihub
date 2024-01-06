package com.tpanh.dinehub.entity;

import com.tpanh.dinehub.entity.key.KeyOrderDetail;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "order_details")
public class OrderDetail extends BaseEntity {
    @EmbeddedId
    private KeyOrderDetail id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "total_money", nullable = false)
    private Float totalMoney;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, insertable = false, updatable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", nullable = false, insertable = false, updatable = false)
    private Food food;

}