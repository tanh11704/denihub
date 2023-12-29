package com.tpanh.dinehub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteFoodDTO {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("food_id")
    private Integer foodId;
}
