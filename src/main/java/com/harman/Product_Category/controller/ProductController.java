package com.harman.Product_Category.controller;

import com.harman.Product_Category.model.Product;
import com.harman.Product_Category.service.CategoryService;
import com.harman.Product_Category.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

//    @GetMapping("/test")
//    public String testing() {
//        return "testing......";
//    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id){
        Product product=productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product){
        Product updatedProduct=productService.update(id, product);
//        Product oldProduct=productService.findById(id);
//        oldProduct.setName(product.getName());
//        oldProduct.setPrice(product.getPrice());
//        oldProduct.setDescription(product.getDescription());
//        oldProduct.setCategoryId(product.getCategoryId());
//        Product updateProduct=productService.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/groupByCategory")
    public Map<Integer, List<Product>> getProductByGroupByCategory(){
        return productService.getProductGroupedByCategory();
    }

    @GetMapping("/priceGreaterThan/{price}")
    public ResponseEntity<List<Product>> getProductWithPriceGreaterThan(@PathVariable Double price){
        return ResponseEntity.ok(productService.getProductWithPriceGreaterThan(price));
    }
}
