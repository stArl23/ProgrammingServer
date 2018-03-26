package com.huidi.spring.boot.initializer.utils;

import com.huidi.spring.boot.initializer.domain.Statistics;

public class StatisticsUtils {

    public static Statistics createStatistics(Integer uId, String qId
            , String answers, Integer totalMarks, Integer currentMarks) {
        Statistics statistics = new Statistics();
        statistics.setId(KeyUtils.genUniqueKey());
        statistics.setQId(qId);
        statistics.setUId(uId);
        statistics.setAnswers(answers);
        statistics.setTotalMarks(totalMarks);
        statistics.setCurrentMarks(currentMarks);
        return statistics;
    }
}
