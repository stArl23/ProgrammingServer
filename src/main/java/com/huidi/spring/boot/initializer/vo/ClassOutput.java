package com.huidi.spring.boot.initializer.vo;

import com.huidi.spring.boot.initializer.domain.Class;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ClassOutput implements Serializable {
    private List<String> className;

    public ClassOutput(Set<Class> classes) {
        List<String> classList = new ArrayList<>();
        for (Class class1 : classes)
            classList.add(class1.getName());
        this.className = classList;
    }

    public List<String> getClassName() {
        return className;
    }

    public void setClassName(List<String> className) {
        this.className = className;
    }
}
