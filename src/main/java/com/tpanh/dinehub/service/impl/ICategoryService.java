package com.tpanh.dinehub.service.impl;

import com.tpanh.dinehub.dto.CategoryDTO;
import com.tpanh.dinehub.entity.Category;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Integer id) throws Exception;
    Category createCategory(CategoryDTO category);
    Category updateCategory(Integer id, CategoryDTO category) throws Exception;
    void deleteCategory(Integer id);
    Category uploadImage(Integer id, MultipartFile file) throws Exception;
}
