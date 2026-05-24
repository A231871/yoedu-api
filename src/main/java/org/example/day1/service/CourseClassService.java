package org.example.day1.service;

import org.example.day1.dto.courseclass.CourseClassResponse;
import org.example.day1.dto.courseclass.CourseClassUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface CourseClassService {
    List<CourseClassResponse> findAll();
    Optional<CourseClassResponse> findById(Long id);
    CourseClassResponse create(CourseClassUpsertRequest req);
    CourseClassResponse update(Long id, CourseClassUpsertRequest req);
}
