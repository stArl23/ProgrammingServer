package com.huidi.spring.boot.initializer.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
public class Statistics {

    @Id
    private String id;
    private Integer uId;
    private String qId;
    private Timestamp createTime;
    private String answers;
    private Integer totalMarks;
    private Integer currentMarks;

    public Statistics() {
    }
}
