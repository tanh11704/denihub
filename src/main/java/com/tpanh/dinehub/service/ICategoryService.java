package com.tpanh.dinehub.service;

import com.tpanh.dinehub.dto.CategoryDTO;
import com.tpanh.dinehub.entity.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(int id);
    Category addCategory(CategoryDTO category);
    Category updateCategory(Integer id, CategoryDTO category);
    void deleteCategory(Integer id);
}
