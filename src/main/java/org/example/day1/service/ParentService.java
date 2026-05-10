package org.example.day1.service;

import org.example.day1.dto.parent.ParentResponse;
import org.example.day1.dto.parent.ParentUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface ParentService {
    List<ParentResponse> findAll();
    Optional<ParentResponse> findById(Long id);
    ParentResponse save(ParentUpsertRequest req);
    ParentResponse update(Long id, ParentUpsertRequest req);
    void delete(Long id);
}
