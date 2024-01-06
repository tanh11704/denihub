package com.tpanh.dinehub.entity;

import com.tpanh.dinehub.entity.key.KeyFoodTag;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "food_tags")
public class FoodTag extends BaseEntity {
    @EmbeddedId
    private KeyFoodTag id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", nullable = false, insertable = false, updatable = false)
    private Food food;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false, insertable = false, updatable = false)
    private Tag tag;

}