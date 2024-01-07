package com.tpanh.dinehub.service;

import com.tpanh.dinehub.dto.CategoryDTO;
import com.tpanh.dinehub.entity.Category;
import com.tpanh.dinehub.exception.DataNotFoundException;
import com.tpanh.dinehub.reponsitory.CategoryRepository;
import com.tpanh.dinehub.response.CategoryResponse;
import com.tpanh.dinehub.service.impl.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) throws Exception {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Category not found"));
    }

    @Override
    public Category createCategory(CategoryDTO category) {
        Category newCategory = new Category();
        modelMapper.map(category, newCategory);
        return categoryRepository.save(newCategory);
    }

    @Override
    public Category updateCategory(Integer id, CategoryDTO category) throws Exception {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Category not found"));
        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    @Override
    public void deleteCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        optionalCategory.ifPresent(category -> categoryRepository.delete(category));
    }

    @Override
    public Category uploadImage(Integer id, MultipartFile file) throws Exception {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Category not found"));

        if (existingCategory.getImage() != null) {
            Path existingImagePath = Paths.get(existingCategory.getImage());
            try {
                Files.deleteIfExists(existingImagePath);
            } catch (IOException e) {
                throw new IOException("Could not delete existing image file: " + existingCategory.getImage(), e);
            }
        }

        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFilename = UUID.randomUUID().toString() + extension;

        Path dirPath = Paths.get("uploads/categories");
        Path filePath = dirPath.resolve(newFilename);

        try {
            Files.createDirectories(dirPath); // This line ensures the directory exists
            Files.copy(file.getInputStream(), filePath);
        } catch (IOException e) {
            throw new IOException("Could not save image file: " + newFilename, e);
        }

        existingCategory.setImage(filePath.toString());
        categoryRepository.save(existingCategory);

        return existingCategory;
    }
}
