package com.huidi.spring.boot.initializer.dao;

import com.huidi.spring.boot.initializer.domain.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterDao extends JpaRepository<Chapter, Integer> {
    List<Chapter> findAllByCourseId(Integer id);
}
