package org.example.day1.service;

import org.example.day1.dto.course.CourseResponse;
import org.example.day1.dto.course.CourseUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<CourseResponse> findAll();
    Optional<CourseResponse> findById(Long id);
    CourseResponse save(CourseUpsertRequest req);
    CourseResponse update(Long id, CourseUpsertRequest req);
    void delete(Long id);

}
