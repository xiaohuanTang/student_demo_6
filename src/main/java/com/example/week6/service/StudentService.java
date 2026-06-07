package com.example.week6.service;

import com.example.week6.dto.StudentRequest;
import com.example.week6.entity.Student;
import com.example.week6.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> list(String keyword) {
        if (StringUtils.hasText(keyword)) {
            return studentRepository.search(keyword.trim());
        }
        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("学生不存在"));
    }

    public int countByMajor(String major) {
        if (!StringUtils.hasText(major)) {
            throw new IllegalArgumentException("专业不能为空");
        }
        return studentRepository.countByMajor(major.trim());
    }

    public void create(StudentRequest request) {
        validate(request);
        studentRepository.insert(request);
    }

    public void update(Long id, StudentRequest request) {
        validate(request);
        getById(id);
        studentRepository.update(id, request);
    }

    public void delete(Long id) {
        getById(id);
        studentRepository.deleteById(id);
    }

    private void validate(StudentRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("请求数据不能为空");
        }
        if (!StringUtils.hasText(request.getStudentNo())) {
            throw new IllegalArgumentException("学号不能为空");
        }
        if (!StringUtils.hasText(request.getName())) {
            throw new IllegalArgumentException("姓名不能为空");
        }
        if (!StringUtils.hasText(request.getGender())) {
            throw new IllegalArgumentException("性别不能为空");
        }
        if (!StringUtils.hasText(request.getMajor())) {
            throw new IllegalArgumentException("专业不能为空");
        }
        if (request.getGrade() == null || request.getGrade() < 2000) {
            throw new IllegalArgumentException("年级不合法");
        }
    }
}
