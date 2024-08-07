package com.harman.Product_Category.repository;

import com.harman.Product_Category.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
    List<Product> findProductByPriceGreaterThan(Double price);
}
