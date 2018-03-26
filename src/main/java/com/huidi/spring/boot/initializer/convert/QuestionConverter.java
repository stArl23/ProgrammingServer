package com.huidi.spring.boot.initializer.convert;

import com.huidi.spring.boot.initializer.domain.Question;
import com.huidi.spring.boot.initializer.dto.QuestionDto;
import com.huidi.spring.boot.initializer.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionConverter {

    public static QuestionDto convertQuestion2Dto(Question question) {
        return convert(question);
    }


    public static List<QuestionDto> convertQuestion2Dto(List<Question> questions) {
        List<QuestionDto> list = new ArrayList<>();
        list = questions.stream().map(e -> convert(e)).collect(Collectors.toList());
        return list;
    }

    //convert question to dto
    private static QuestionDto convert(Question question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setDesc(question.getDescription());
        questionDto.setItems(StringUtils.string2List(question.getItems()));
        questionDto.setId(question.getId());
        return questionDto;
    }
}
