package com.harman.Product_Category.repository;

import com.harman.Product_Category.model.Category;
import com.harman.Product_Category.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, Integer> {
}
