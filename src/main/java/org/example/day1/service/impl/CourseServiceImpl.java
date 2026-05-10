package org.example.day1.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.day1.common.exception.NotFoundException;
import org.example.day1.domain.entity.Course;
import org.example.day1.dto.course.CourseResponse;
import org.example.day1.dto.course.CourseUpsertRequest;
import org.example.day1.repository.CourseRepository;
import org.example.day1.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public List<CourseResponse> findAll() {
        return courseRepository.findAll().stream()
                .map(this::map)
                .toList();
    }

    public Optional<CourseResponse> findById(Long id) {
        return courseRepository.findById(id)
                .map(this::map);
    }

    public CourseResponse save(CourseUpsertRequest req) {
        Course course = modelMapper.map(req, Course.class);
        return map(courseRepository.save(course));
    }

    public CourseResponse update(Long id, CourseUpsertRequest req) {
        Course updateCourse = courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course not found with id: " + id));
        updateCourse.setCourseCode(req.getCourseCode());
        updateCourse.setName(req.getName());
        updateCourse.setDescription(req.getDescription());
        updateCourse.setTuitionFee(req.getTuitionFee());
        updateCourse.setTotalSessions(req.getTotalSessions());
        updateCourse.setIsActive(req.getIsActive());
        return map(courseRepository.save(updateCourse));
    }

    public void delete(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new NotFoundException("Course not found with id: " + id);
        }
        courseRepository.deleteById(id);
    }

    public CourseResponse map(Course course) {
        return modelMapper.map(course, CourseResponse.class);
    }
}
