package org.example.day1.service;

import org.example.day1.dto.student.StudentResponse;
import org.example.day1.dto.student.StudentUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface StudentService {
//    List<StudentResponse> findAll();
//    Optional<Student> findById(Long id);
//    Student save(Student student);
//    Optional<Student> update(Long id, Student student);
//    boolean delete(Long id);
    List<StudentResponse> findAll();
    Optional<StudentResponse> findById(Long id);
    StudentResponse save(StudentUpsertRequest req);
    StudentResponse update(Long id,StudentUpsertRequest req);
    void delete(Long id);
}
