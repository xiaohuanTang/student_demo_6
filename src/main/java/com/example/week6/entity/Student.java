package com.example.week6.entity;

import java.time.LocalDateTime;

public class Student {
    private Long id;
    private String studentNo;
    private String name;
    private String gender;
    private String major;
    private Integer grade;
    private String phone;
    private LocalDateTime createTime;

    public Student() {
    }

    public Student(Long id, String studentNo, String name, String gender, String major, Integer grade, String phone, LocalDateTime createTime) {
        this.id = id;
        this.studentNo = studentNo;
        this.name = name;
        this.gender = gender;
        this.major = major;
        this.grade = grade;
        this.phone = phone;
        this.createTime = createTime;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getStudentNo() { return studentNo; }
    public void setStudentNo(String studentNo) { this.studentNo = studentNo; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public Integer getGrade() { return grade; }
    public void setGrade(Integer grade) { this.grade = grade; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
}
