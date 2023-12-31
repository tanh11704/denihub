package com.tpanh.dinehub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tpanh.dinehub.entity.Category;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
    private String name;
    private Double price;
    private String description;
    private Integer calories;
    private Integer weight;
    @JsonProperty("food_type")
    private String foodType;
    @JsonProperty("category_id")
    private Integer categoryId;
}
