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
    @JsonProperty("food_id")
    private Integer foodId;

    @JsonProperty("user_id")
    private Integer userId;
}
