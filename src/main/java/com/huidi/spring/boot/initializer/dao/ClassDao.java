package com.huidi.spring.boot.initializer.dao;

import com.huidi.spring.boot.initializer.domain.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassDao extends JpaRepository<Class, Integer> {
    /*public List<Class> findAllByChapter_ChapterName(String chapterName);*/

    List<Class> findAllByChapterId(Integer id);
}
