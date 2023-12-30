package com.tpanh.dinehub.reponsitory;

import com.tpanh.dinehub.entity.FavoriteFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteFoodRepository extends JpaRepository<FavoriteFood, Integer> {
}