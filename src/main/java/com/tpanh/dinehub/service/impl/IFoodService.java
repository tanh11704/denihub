package com.tpanh.dinehub.service.impl;

import com.tpanh.dinehub.dto.FoodDTO;
import com.tpanh.dinehub.entity.Food;
import com.tpanh.dinehub.response.FoodResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFoodService {
    List<FoodResponse> getAllFoods();
    Food getFoodById(Integer id) throws Exception;
    Food createFood(FoodDTO food);
    Food updateFood(Integer id, FoodDTO food) throws Exception;
    void deleteFood(Integer id);
    Food uploadImage(Integer id, MultipartFile file) throws Exception;
}
