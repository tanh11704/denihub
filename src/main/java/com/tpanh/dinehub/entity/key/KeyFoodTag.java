package com.tpanh.dinehub.entity.key;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KeyFoodTag implements Serializable {

    @Column(name = "food_id", nullable = false)
    private Integer foodId;

    @Column(name = "tag_id", nullable = false)
    private Integer tagId;
}
