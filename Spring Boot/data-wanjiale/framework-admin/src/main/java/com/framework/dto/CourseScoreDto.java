package com.framework.dto;


/*
 *功能描述
 * @author tangfl
 * @description 课程推荐课程分数封装DTO
 * @date
 */

public class CourseScoreDto {
    private String score;
    private String member;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }
}
