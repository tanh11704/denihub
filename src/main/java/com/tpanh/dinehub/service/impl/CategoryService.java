package com.tpanh.dinehub.service.impl;

import com.tpanh.dinehub.dto.CategoryDTO;
import com.tpanh.dinehub.entity.Category;
import com.tpanh.dinehub.reponsitory.CategoryRepository;
import com.tpanh.dinehub.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category addCategory(CategoryDTO category) {
        Category newCategory = new Category()
                .builder()
                .name(category.getName())
                .build();
        return categoryRepository.save(newCategory);
    }

    @Override
    public Category updateCategory(Integer id, CategoryDTO category) {
        return categoryRepository.findById(id)
                .map(c -> {
                    c.setName(category.getName());
                    return categoryRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Category with id " + id + " not found"));
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
