package com.tpanh.dinehub.entity;

import com.tpanh.dinehub.entity.key.KeyFavoriteFood;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "favorite_foods")
public class FavoriteFood extends BaseEntity {
    @EmbeddedId
    private KeyFavoriteFood id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", nullable = false, insertable = false, updatable = false)
    private Food food;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private User user;

}