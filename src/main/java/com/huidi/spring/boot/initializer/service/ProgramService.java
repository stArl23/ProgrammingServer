package com.huidi.spring.boot.initializer.service;

import com.huidi.spring.boot.initializer.domain.Program;
import com.huidi.spring.boot.initializer.vo.CommonOutput;
import com.huidi.spring.boot.initializer.vo.ProgramOutput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProgramService {

    List<ProgramOutput> getPrograms();

    Page<Program> getPrograms(Pageable pageable);

    List<ProgramOutput> getPrograms(String categoryName, Pageable pageable);

    ProgramOutput getProgram(Integer id);

    CommonOutput deleteProgramFromUser(Integer programId, Integer userId);

    CommonOutput appendProgramForUser(Integer programId, Integer userId);

    List<ProgramOutput> getCollectionsByUserId(Integer userId);

    List<ProgramOutput> fuzzyQueryPrograms(String cond);

    List<ProgramOutput> getProgramsByUserId(Integer userId);

    CommonOutput deleteCollectionFromUser(Integer programId, Integer userId);

    CommonOutput appendCollectionForUser(Integer programId, Integer userId);
}
