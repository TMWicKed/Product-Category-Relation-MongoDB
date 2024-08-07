package com.harman.Product_Category.service;

import com.harman.Product_Category.exception.ResourceNotFoundException;
import com.harman.Product_Category.model.Category;
import com.harman.Product_Category.model.Product;
import com.harman.Product_Category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category not found"));
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }
}
