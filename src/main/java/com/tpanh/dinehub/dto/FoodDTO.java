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
//    private Integer id;
    @JsonProperty("category_id")
    private Integer categoryId;
    private String name;
    private String image;
    private Float price;
    private String description;
    private Integer calories;
    private Integer weight;
//    @JsonProperty("updated_at")
//    private String updatedAt;
//    @JsonProperty("created_at")
//    private String createdAt;
}
