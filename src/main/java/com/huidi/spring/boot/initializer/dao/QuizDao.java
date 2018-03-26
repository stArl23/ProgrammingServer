package com.huidi.spring.boot.initializer.dao;

import com.huidi.spring.boot.initializer.domain.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizDao extends JpaRepository<Quiz, String> {

    Page<Quiz> findAllByTitleContains(String title, Pageable pageable);

    List<Quiz> findAllByTitleContains(String title);
}
