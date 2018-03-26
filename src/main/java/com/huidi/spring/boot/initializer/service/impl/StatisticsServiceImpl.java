package com.huidi.spring.boot.initializer.service.impl;

import com.huidi.spring.boot.initializer.dao.StatisticsDao;
import com.huidi.spring.boot.initializer.domain.Statistics;
import com.huidi.spring.boot.initializer.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private StatisticsDao statisticsDao;

    @Override
    public Page<Statistics> getStatistics(Pageable pageable) {
        return statisticsDao.findAll(pageable);
    }
}
