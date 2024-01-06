package com.tpanh.dinehub.entity.key;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KeyRatingFood implements Serializable {
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "food_id", nullable = false)
    private Integer foodId;
}
