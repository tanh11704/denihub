package com.tpanh.dinehub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodTagDTO {
    @JsonProperty("food_id")
    private Integer foodId;

    @JsonProperty("tag_id")
    private Integer tagId;
}
