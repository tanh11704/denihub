package com.tpanh.dinehub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
    @JsonProperty("category_id")
    private Integer categoryId;
    private String name;
    private String image;
    private Float price;
    private String description;
    private Integer calories;
    private Integer weight;
}
