package com.huidi.spring.boot.initializer.controller;

import com.huidi.spring.boot.initializer.domain.Program;
import com.huidi.spring.boot.initializer.service.ProgramService;
import com.huidi.spring.boot.initializer.vo.ProgramOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping("/view/programs")
public class ProgramViewController {
    @Autowired
    private ProgramService programService;

    @GetMapping("/list")
    public ModelAndView listProgram(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                    @RequestParam(name = "size", defaultValue = "5") Integer size,
                                    HashMap<String, Object> map) {
        Page<Program> programs = programService.getPrograms(new PageRequest(page, size));
        map.put("programs", programs);
        map.put("page", page);
        map.put("size", size);
        ModelAndView modelAndView = new ModelAndView("program/list", map);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getProgram(@PathVariable("id") Integer id,
                                   HashMap<String, Object> map) {
        ProgramOutput program = programService.getProgram(id);
        map.put("program", program);
        return new ModelAndView("");
    }
}
