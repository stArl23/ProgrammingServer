package com.huidi.spring.boot.initializer.service;

import com.huidi.spring.boot.initializer.domain.Statistics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StatisticsService {
    Page<Statistics> getStatistics(Pageable pageable);
}
