package com.huidi.spring.boot.initializer.dao;

import com.huidi.spring.boot.initializer.domain.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticsDao extends JpaRepository<Statistics, String> {
}
