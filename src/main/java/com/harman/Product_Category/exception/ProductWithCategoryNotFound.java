package com.harman.Product_Category.exception;

import org.springframework.dao.DataAccessException;

public class ProductWithCategoryNotFound extends Throwable {
    public ProductWithCategoryNotFound() {
    }

    public ProductWithCategoryNotFound(String message) {
        super(message);
    }

    public ProductWithCategoryNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductWithCategoryNotFound(Throwable cause) {
        super(cause);
    }

    public ProductWithCategoryNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ProductWithCategoryNotFound(String s, DataAccessException e) {
    }
}
