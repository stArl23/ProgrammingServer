package com.huidi.spring.boot.initializer.dao;

import com.huidi.spring.boot.initializer.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {

    Category findByName(String name);
}
