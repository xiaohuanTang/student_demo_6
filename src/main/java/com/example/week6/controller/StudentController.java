package com.example.week6.controller;

import com.example.week6.dto.ApiResponse;
import com.example.week6.dto.StudentRequest;
import com.example.week6.entity.Student;
import com.example.week6.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ApiResponse<List<Student>> list(@RequestParam(required = false) String keyword) {
        return ApiResponse.ok(studentService.list(keyword));
    }

    @GetMapping("/{id}")
    public ApiResponse<Student> detail(@PathVariable Long id) {
        return ApiResponse.ok(studentService.getById(id));
    }

    @GetMapping("/count")
    public ApiResponse<Map<String, Object>> countByMajor(@RequestParam String major) {
        int count = studentService.countByMajor(major);
        return ApiResponse.ok(Map.of("major", major, "count", count));
    }

    @PostMapping
    public ApiResponse<Void> create(@RequestBody StudentRequest request) {
        studentService.create(request);
        return ApiResponse.ok("新增成功", null);
    }

    @PutMapping("/{id}")
    public ApiResponse<Void> update(@PathVariable Long id, @RequestBody StudentRequest request) {
        studentService.update(id, request);
        return ApiResponse.ok("修改成功", null);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ApiResponse.ok("删除成功", null);
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<Void> handleException(Exception e) {
        return ApiResponse.fail(e.getMessage());
    }
}
