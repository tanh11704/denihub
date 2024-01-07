package com.tpanh.dinehub.service;

import com.tpanh.dinehub.dto.FoodDTO;
import com.tpanh.dinehub.entity.Food;
import com.tpanh.dinehub.reponsitory.FoodRepository;
import com.tpanh.dinehub.response.FoodResponse;
import com.tpanh.dinehub.service.impl.IFilesStorageService;
import com.tpanh.dinehub.service.impl.IFoodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodService implements IFoodService {

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IFilesStorageService filesStorageService;

    @Override
    public List<FoodResponse> getAllFoods() {
        return foodRepository.findAll().stream().map(
                (element) -> modelMapper.map(element, FoodResponse.class)).collect(Collectors.toList()
        );
    }

    @Override
    public Food getFoodById(Integer id) throws Exception {
        Food food = foodRepository.findById(id).orElseThrow(
                () -> new Exception("Food not found")
        );
        return food;
    }

    @Override
    public Food createFood(FoodDTO food) {
        Food newFood = new Food();
        modelMapper.map(food, newFood);
        newFood.setId(null);
        return foodRepository.save(newFood);
    }

    @Override
    public Food updateFood(Integer id, FoodDTO food) throws Exception {
        Food existFood = foodRepository.findById(id).orElseThrow(
                () -> new Exception("Food not found")
        );
        modelMapper.map(food, existFood);
        return foodRepository.save(existFood);
    }

    @Override
    public void deleteFood(Integer id) {
        Optional<Food> food = foodRepository.findById(id);
        food.ifPresent(value -> foodRepository.delete(value));
    }

    @Override
    public Food uploadImage(Integer id, MultipartFile file) throws Exception {
        Food existFood = foodRepository.findById(id).orElseThrow(
                () -> new Exception("Food not found")
        );

        if (existFood.getImage() != null) {
            Path existingImagePath = Paths.get(existFood.getImage());
            Files.deleteIfExists(existingImagePath);
        }


        String fileName = filesStorageService.save(file, "foods");
        existFood.setImage(fileName);
        return foodRepository.save(existFood);
    }
}
