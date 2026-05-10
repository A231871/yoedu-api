package org.example.day1.service;

import org.example.day1.dto.teacher.TeacherResponse;
import org.example.day1.dto.teacher.TeacherUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<TeacherResponse> findAll();
    Optional<TeacherResponse> findById(Long id);
    TeacherResponse save(TeacherUpsertRequest req);
    TeacherResponse update(Long id, TeacherUpsertRequest req);
    void delete(Long id);
}
