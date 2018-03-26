package com.huidi.spring.boot.initializer.dao;

import com.huidi.spring.boot.initializer.domain.Program;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProgramDao extends JpaRepository<Program, Integer> {

    Program findById(Integer id);

    Page<Program> findAllByDeletedIsFalse(Pageable pageable);

    Page<Program> findAllByCategoryNameAndDeletedIsFalse(String categoryName, Pageable pageable);

    List<Program> findAllByIdIn(List<Integer> ids);

    //模糊匹配
    @Query("select p from Program p where " +
            "(p.categoryName like CONCAT('%',:cn,'%') " +
            "or p.author like CONCAT('%',:a,'%') " +
            "or p.title like CONCAT('%',:t,'%') " +
            "or p.content like CONCAT('%',:c,'%')) and p.deleted <> 1 ")
    List<Program> fuzzyQueryPrograms(@Param("cn") String categoryName,
                                     @Param("a") String author,
                                     @Param("t") String title,
                                     @Param("c") String content);

}
