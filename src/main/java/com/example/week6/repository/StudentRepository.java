package com.example.week6.repository;

import com.example.week6.dto.StudentRequest;
import com.example.week6.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Student> rowMapper = (rs, rowNum) -> new Student(
            rs.getLong("id"),
            rs.getString("student_no"),
            rs.getString("name"),
            rs.getString("gender"),
            rs.getString("major"),
            rs.getInt("grade"),
            rs.getString("phone"),
            rs.getTimestamp("create_time").toLocalDateTime()
    );

    public List<Student> findAll() {
        String sql = "SELECT * FROM student ORDER BY id DESC";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Optional<Student> findById(Long id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        List<Student> list = jdbcTemplate.query(sql, rowMapper, id);
        return list.stream().findFirst();
    }

    public List<Student> search(String keyword) {
        String sql = "SELECT * FROM student WHERE student_no LIKE ? OR name LIKE ? OR major LIKE ? ORDER BY id DESC";
        String value = "%" + keyword + "%";
        return jdbcTemplate.query(sql, rowMapper, value, value, value);
    }

    public int countByMajor(String major) {
        String sql = "SELECT COUNT(*) FROM student WHERE major = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, major);
        return count == null ? 0 : count;
    }

    public int insert(StudentRequest request) {
        String sql = "INSERT INTO student(student_no, name, gender, major, grade, phone) VALUES(?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                request.getStudentNo(),
                request.getName(),
                request.getGender(),
                request.getMajor(),
                request.getGrade(),
                request.getPhone());
    }

    public int update(Long id, StudentRequest request) {
        String sql = "UPDATE student SET student_no = ?, name = ?, gender = ?, major = ?, grade = ?, phone = ? WHERE id = ?";
        return jdbcTemplate.update(sql,
                request.getStudentNo(),
                request.getName(),
                request.getGender(),
                request.getMajor(),
                request.getGrade(),
                request.getPhone(),
                id);
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM student WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
