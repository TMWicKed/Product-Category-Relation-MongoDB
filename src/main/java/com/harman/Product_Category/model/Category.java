package com.harman.Product_Category.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;


@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    private Integer id;

    private String name;
    private String description;
    
    private Map<String, Integer> productQuantity;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
