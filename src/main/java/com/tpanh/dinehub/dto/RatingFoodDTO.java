package com.tpanh.dinehub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingFoodDTO {
//    private Integer id;
    @JsonProperty("food_id")
    private Integer foodId;
    @JsonProperty("user_id")
    private Integer userId;
    private String content;
    @JsonProperty("rate_point")
    private Integer ratePoint;
//    @JsonProperty("updated_at")
//    private String updatedAt;
//    @JsonProperty("created_at")
//    private String createdAt;
}
