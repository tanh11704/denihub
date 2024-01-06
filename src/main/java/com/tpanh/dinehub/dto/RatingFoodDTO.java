package com.tpanh.dinehub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tpanh.dinehub.entity.Food;
import com.tpanh.dinehub.entity.User;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingFoodDTO {
    private String content;

    private Integer ratePoint;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("food_id")
    private Integer foodId;
}