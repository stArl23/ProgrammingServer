package com.huidi.spring.boot.initializer.vo;

import com.huidi.spring.boot.initializer.domain.Category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryOutput implements Serializable {
    private List<String> categories;


    public CategoryOutput(List<Category> categories1) {
        this.categories = new ArrayList<String>();
        for (Category category : categories1) {
            categories.add(category.getName());
        }
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
