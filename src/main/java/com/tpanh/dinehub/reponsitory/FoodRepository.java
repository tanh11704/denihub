package com.tpanh.dinehub.reponsitory;

import com.tpanh.dinehub.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {
}