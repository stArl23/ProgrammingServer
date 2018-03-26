package com.huidi.spring.boot.initializer.controller;

import com.huidi.spring.boot.initializer.service.CommentService;
import com.huidi.spring.boot.initializer.service.ProgramService;
import com.huidi.spring.boot.initializer.vo.CommentOutput;
import com.huidi.spring.boot.initializer.vo.ProgramOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programs")
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<ProgramOutput> listPrograms(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                            @RequestParam(name = "size", defaultValue = "5") Integer size,
                                            @RequestParam(name = "category", required = false, defaultValue = "") String categoryName,
                                            @RequestParam(name = "orderBy", required = false, defaultValue = "") String orderBy,
                                            @RequestParam(name = "direction", required = false, defaultValue = "1") Integer direction) {
        Pageable pageable;
        if ("".equals(orderBy))
            pageable = new PageRequest(page, size);
        else
            pageable = direction == 1 ? new PageRequest(page, size, Sort.Direction.ASC, orderBy)
                    : new PageRequest(page, size, Sort.Direction.DESC, orderBy);
        return programService.getPrograms(categoryName, pageable);
    }

    @GetMapping("/{id}")
    public ProgramOutput getProgram(@PathVariable(name = "id") Integer id) {
        return programService.getProgram(id);
    }


    @GetMapping("/{programid}/comments")
    public List<CommentOutput> listProgramComments(@PathVariable(name = "programid") Integer id) {
        return commentService.getCommentByProgramId(id);
    }

    //程序模糊查询接口
    @GetMapping("/search/{cond}")
    public List<ProgramOutput> fuzzyQuery(@PathVariable("cond") String cond) {
        return programService.fuzzyQueryPrograms(cond);
    }

}
