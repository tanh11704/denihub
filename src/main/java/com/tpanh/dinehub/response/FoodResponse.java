package com.tpanh.dinehub.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tpanh.dinehub.entity.Food;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({"id", "name", "image", "price", "description", "calories", "weight", "food_type", "category_id", "created_at", "updated_at"})
public class FoodResponse extends BaseResponse {
    private Integer id;
    private String name;
    private String image;
    private Double price;
    private String description;
    private Integer calories;
    private Integer weight;
    @JsonProperty("food_type")
    private String foodType;
    @JsonProperty("category_id")
    private Integer categoryId;

    public FoodResponse fromFood(Food food) {
        FoodResponse foodResponse = new FoodResponse()
                .builder()
                .id(food.getId())
                .name(food.getName())
                .image(food.getImage())
                .price(food.getPrice())
                .description(food.getDescription())
                .calories(food.getCalories())
                .weight(food.getWeight())
                .foodType(food.getFoodType())
                .categoryId(food.getCategory().getId())
                .build();
        foodResponse.setCreatedAt(food.getCreatedAt());
        foodResponse.setUpdatedAt(food.getUpdatedAt());
        return foodResponse;
    }
}
