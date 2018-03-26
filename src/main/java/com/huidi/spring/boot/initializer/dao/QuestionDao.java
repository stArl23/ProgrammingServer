package com.huidi.spring.boot.initializer.dao;

import com.huidi.spring.boot.initializer.domain.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question, String> {

    public Page<Question> findAllByDescriptionLike(String desc, Pageable pageable);

    public List<Question> findAllByDescriptionLike(String desc);

    public List<Question> findAllByIdIn(List<String> ids);
}
