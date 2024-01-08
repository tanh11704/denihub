package com.tpanh.dinehub.controller;

import com.github.javafaker.Faker;
import com.tpanh.dinehub.dto.FoodDTO;
import com.tpanh.dinehub.entity.Food;
import com.tpanh.dinehub.response.FoodResponse;
import com.tpanh.dinehub.service.impl.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/foods")
public class FoodController {

    @Autowired
    IFoodService foodService;

    @GetMapping
    public ResponseEntity<List<FoodResponse>> getAllFoods() {
        List<FoodResponse> foods = foodService.getAllFoods();
        return ResponseEntity.ok(foods);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodResponse> getFoodById(@PathVariable("id") Integer id) throws Exception {
        Food food = foodService.getFoodById(id);
        FoodResponse foodResponse = new FoodResponse().fromFood(food);
        return ResponseEntity.ok(foodResponse);
    }

    @PostMapping
    public ResponseEntity<FoodResponse> createFood(@RequestBody FoodDTO food) {
        Food createdFood = foodService.createFood(food);
        FoodResponse foodResponse = new FoodResponse().fromFood(createdFood);
        return ResponseEntity.ok(foodResponse);
    }

    @PostMapping(value = "/upload/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<FoodResponse> uploadImage(
            @PathVariable("id") Integer id,
            @ModelAttribute("file") MultipartFile file
    ) throws Exception {
        Food updatedFood = foodService.uploadImage(id, file);
        FoodResponse foodResponse = new FoodResponse().fromFood(updatedFood);
        return ResponseEntity.ok(foodResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodResponse> updateFood(@PathVariable("id") Integer id, @RequestBody FoodDTO food) throws Exception {
        Food updatedFood = foodService.updateFood(id, food);
        FoodResponse foodResponse = new FoodResponse().fromFood(updatedFood);
        return ResponseEntity.ok(foodResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable("id") Integer id) {
        foodService.deleteFood(id);
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/generateFakeFood")
    private ResponseEntity<String> generateFakeFood() {
        Faker faker = new Faker();
        for (int i = 0; i < 50; i++) {
            FoodDTO foodDTO = new FoodDTO()
                    .builder()
                    .name(faker.food().dish())
                    .price(faker.number().randomDouble(2, 1, 100))
                    .description(faker.lorem().sentence())
                    .calories(faker.number().numberBetween(50, 500))
                    .weight(faker.number().numberBetween(50, 500))
                    .foodType(faker.options().option("", "new", "hot", "recommend"))
                    .categoryId(faker.number().numberBetween(1, 6))
                    .build();
            foodService.createFood(foodDTO);
        }
        return ResponseEntity.ok("Generate fake food successfully");
    }
}
