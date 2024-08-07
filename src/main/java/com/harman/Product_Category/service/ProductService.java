package com.harman.Product_Category.service;

import com.harman.Product_Category.exception.ProductNotFoundException;
import com.harman.Product_Category.model.Product;
import com.harman.Product_Category.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        try {
            return productRepository.findAll();
        }catch (DataAccessException e) {
            throw new RuntimeException("Failed to retrieve products: " + e.getMessage(), e);
        }
    }

    public Product findById(Integer id) {
        try {
            Optional<Product> product = productRepository.findById(id);
            if (product.isPresent()) {
                return product.get();
            } else {
                throw new ProductNotFoundException("Product with ID " + id + " not found");
            }
        } catch (DataAccessException | ProductNotFoundException e) {
            throw new RuntimeException("Failed to retrieve product: " + e.getMessage(), e);
        }
    }

    public Product save(Product product) {
        try {
            return productRepository.save(product);
        }catch (DataAccessException e) {
            throw new RuntimeException("Error while creating product: " + e.getMessage(), e);
        }
    }



    public void deleteById(Integer id) {
        try {
            productRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to delete product: " + e.getMessage(), e);
        }
    }


    public Map<Integer, List<Product>> getProductGroupedByCategory() {
        try {
            return productRepository.findAll().stream()
                    .collect(Collectors.groupingBy(Product::getCategoryId));
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to group products by category: " + e.getMessage(), e);
        }
    }

    public Product update(Integer id, Product product) {
        try {
            Product oldProduct = findById(id);
            if (product.getName()!=null)
                oldProduct.setName(product.getName());
            if (product.getPrice()!=null)
                oldProduct.setPrice(product.getPrice());
            if (product.getDescription()!=null)
               oldProduct.setDescription(product.getDescription());
            if (product.getCategoryId()!=null)
                oldProduct.setCategoryId(product.getCategoryId());
            return productRepository.save(oldProduct);
        }catch (DataAccessException e) {
            throw new RuntimeException("Failed to update product: " + e.getMessage(), e);
        }
    }

    public List<Product> getProductWithPriceGreaterThan(Double price) {
        List<Product> products = productRepository.findProductByPriceGreaterThan(price);
        Double totalprice=0.0;
        for (Product product : products){
            totalprice=totalprice+product.getPrice();
        }
        System.out.println("Total price: " + totalprice);
        return products;
    }
}
