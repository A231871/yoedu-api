package org.example.day1.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.day1.common.ApiResponse;
import org.example.day1.dto.teacher.TeacherResponse;
import org.example.day1.dto.teacher.TeacherUpsertRequest;
import org.example.day1.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<TeacherResponse>>> findAll() {
        return ResponseEntity.ok(ApiResponse.success(teacherService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<TeacherResponse>> findById(@PathVariable("id") Long id) {
        Optional<TeacherResponse> teacher = teacherService.findById(id);
        if(teacher.isPresent()) {
            return ResponseEntity.ok(ApiResponse.success(teacher.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TeacherResponse>> save(@Valid @RequestBody TeacherUpsertRequest req) {
        return ResponseEntity.ok(ApiResponse.success(teacherService.save(req)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<TeacherResponse>> update(@PathVariable("id") Long id,
                                                               @Valid @RequestBody TeacherUpsertRequest req) {
        return ResponseEntity.ok(ApiResponse.success(teacherService.update(id, req)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable("id") Long id) {
        teacherService.delete(id);
        return ResponseEntity.ok(ApiResponse.successMessage("Success"));
    }
}
