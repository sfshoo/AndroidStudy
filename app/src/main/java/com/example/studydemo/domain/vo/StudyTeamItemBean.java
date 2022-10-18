package com.example.studydemo.domain.vo;

public class StudyTeamItemBean {
    private String name;
    private Integer age;
    private String description;

    public StudyTeamItemBean(String name, Integer age, String description) {
        this.name = name;
        this.age = age;
        this.description = description;
    }

    public StudyTeamItemBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
