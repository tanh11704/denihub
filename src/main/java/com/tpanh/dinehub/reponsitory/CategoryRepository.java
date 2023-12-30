package com.tpanh.dinehub.reponsitory;

import com.tpanh.dinehub.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}