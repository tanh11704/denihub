package com.tpanh.dinehub.service.impl;

import com.tpanh.dinehub.dto.FoodTagDTO;
import com.tpanh.dinehub.entity.FoodTag;

import java.util.List;

public interface IFoodTagService {
    FoodTag save(FoodTagDTO foodTag);
    List<FoodTag> getFoodTagByUserId(Integer userId);
    void deleteFoodTag(Integer id);
}
