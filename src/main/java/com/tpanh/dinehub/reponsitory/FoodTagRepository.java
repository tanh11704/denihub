package com.tpanh.dinehub.reponsitory;

import com.tpanh.dinehub.entity.FoodTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodTagRepository extends JpaRepository<FoodTag, Integer> {

}