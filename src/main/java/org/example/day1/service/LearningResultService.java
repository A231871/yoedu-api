package org.example.day1.service;

import org.example.day1.common.exception.ConflictException;
import org.example.day1.dto.learningresult.LearningResultCreateRequest;
import org.example.day1.dto.learningresult.LearningResultResponse;

import java.util.List;

public interface LearningResultService {
    LearningResultResponse create(LearningResultCreateRequest request, String username) throws ConflictException;
    List<LearningResultResponse> findByStudentId(Long studentId, String username);
}
