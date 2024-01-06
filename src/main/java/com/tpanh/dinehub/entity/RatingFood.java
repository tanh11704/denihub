package com.tpanh.dinehub.entity;

import com.tpanh.dinehub.entity.key.KeyRatingFood;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "rating_foods")
public class RatingFood {
    @EmbeddedId
    private KeyRatingFood id;

    @Column(name = "content")
    private String content;

    @Column(name = "rate_point", nullable = false)
    private Integer ratePoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", nullable = false, insertable = false, updatable = false)
    private Food food;

}