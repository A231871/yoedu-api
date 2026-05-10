package org.example.day1.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.day1.common.ApiResponse;
import org.example.day1.dto.course.CourseResponse;
import org.example.day1.dto.course.CourseUpsertRequest;
import org.example.day1.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CourseResponse>>> findAll() {
        return ResponseEntity.ok(ApiResponse.success(courseService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<CourseResponse>> findById(@PathVariable("id") Long id) {
        Optional<CourseResponse> course = courseService.findById(id);
        if(course.isPresent()) {
            return ResponseEntity.ok(ApiResponse.success(course.get()));
        } else  {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CourseResponse>> save(@Valid @RequestBody CourseUpsertRequest req) {
        return ResponseEntity.ok(ApiResponse.success(courseService.save(req)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<CourseResponse>> update(@PathVariable("id") Long id,
                                                              @Valid @RequestBody CourseUpsertRequest req) {
        return ResponseEntity.ok(ApiResponse.success(courseService.update(id, req)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable("id") Long id) {
        courseService.delete(id);
        return ResponseEntity.ok(ApiResponse.successMessage("Success"));
    }
}
