package com.huidi.spring.boot.initializer.dao;

import com.huidi.spring.boot.initializer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    User findById(Integer id);

    User findDistinctByMobilephone(String mobilephone);

    User findDistinctByUsername(String username);

    User findDistinctByUsernameAndPassword(String username, String password);

    List<User> findAllByCollectionsContains(Integer programId);

    List<User> findAllByIdIn(List<Integer> ids);

    User findDistinctByProgramsContaining(Integer programId);

    //模糊匹配
    //Page<User> fuzzyQueryUsers(String condition,Pageable pageable);

    @Query("select u from User u where u.description like CONCAT('%',:d,'%') " +
            "or u.nickname like CONCAT('%',:n,'%')" +
            "or u.username like CONCAT('%',:u,'%')")
    List<User> fuzzyQueryUsers(@Param("d") String desc, @Param("n") String nickname, @Param("u") String username);
}
