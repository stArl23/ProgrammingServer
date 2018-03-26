package com.huidi.spring.boot.initializer.controller;

import com.huidi.spring.boot.initializer.domain.Statistics;
import com.huidi.spring.boot.initializer.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping("/view/statisticses")
public class StatisticsViewController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/list")
    ModelAndView listStatistics(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                @RequestParam(name = "size", defaultValue = "5") Integer size,
                                HashMap<String, Object> map) {
        Page<Statistics> statistics = statisticsService.getStatistics(new PageRequest(page, size));
        map.put("statisticses", statistics);
        map.put("page", page);
        map.put("size", size);
        ModelAndView modelAndView = new ModelAndView("statistics/list", map);
        return modelAndView;
    }
}
