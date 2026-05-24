package org.example.day1.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.day1.common.ApiResponse;
import org.example.day1.common.exception.ConflictException;
import org.example.day1.dto.learningresult.LearningResultCreateRequest;
import org.example.day1.dto.learningresult.LearningResultResponse;
import org.example.day1.service.LearningResultService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/learning-results")
public class LearningResultController {
    private final LearningResultService learningResultService;
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','ACADEMIC_STAFF')")
    public ApiResponse<LearningResultResponse> create(@Valid @RequestBody
                                                          LearningResultCreateRequest request, Principal principal)
            throws ConflictException {
        return ApiResponse.success("Learning result created", learningResultService.create(request, principal.getName()));
    }

    @GetMapping("/student/{studentId}")
    @PreAuthorize("hasAnyRole('ADMIN','ACADEMIC_STAFF','PARENT')")
    public ApiResponse<List<LearningResultResponse>> findByStudentId(@PathVariable Long studentId, Principal principal) {
        return ApiResponse.success(learningResultService.findByStudentId(studentId, principal.getName()));
    }
}
