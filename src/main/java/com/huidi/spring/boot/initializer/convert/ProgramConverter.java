package com.huidi.spring.boot.initializer.convert;

import com.huidi.spring.boot.initializer.domain.Program;
import com.huidi.spring.boot.initializer.vo.ProgramOutput;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramConverter {

    public static ProgramOutput converter(Program program) {
        ProgramOutput programOutput = new ProgramOutput();
        BeanUtils.copyProperties(program, programOutput);
        programOutput.setCategories(Arrays.asList(program.getCategoryName()));
        return programOutput;
    }

    public static List<ProgramOutput> converter(List<Program> programs) {
        List<ProgramOutput> programOutputs = new ArrayList<>();
        programOutputs = programs.stream()
                .map(e -> converter(e))
                .collect(Collectors.toList());
        return programOutputs;
    }
}
