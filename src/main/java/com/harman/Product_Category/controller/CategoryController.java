package com.harman.Product_Category.controller;

import com.harman.Product_Category.model.Category;
import com.harman.Product_Category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategories(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id){
        Category category=categoryService.findById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category){
        return categoryService.save(category);
    }

    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category category){
        Category oldCategory=categoryService.findById(id);
        if (category.getDescription()!=null)
            oldCategory.setDescription(category.getDescription());
        if (category.getName()!=null)
            oldCategory.setName(category.getName());
        Category updatedCategory=categoryService.save(oldCategory);
        return ResponseEntity.ok(updatedCategory).getBody();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id){
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
