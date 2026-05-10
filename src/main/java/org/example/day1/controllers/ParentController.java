package org.example.day1.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.day1.common.ApiResponse;
import org.example.day1.dto.parent.ParentResponse;
import org.example.day1.dto.parent.ParentUpsertRequest;
import org.example.day1.service.ParentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/parents")
@RequiredArgsConstructor
public class ParentController {

    private final ParentService parentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ParentResponse>>> findAll() {
        return ResponseEntity.ok(ApiResponse.success(parentService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<ParentResponse>> findById(@PathVariable("id") Long id) {
        Optional<ParentResponse> parent = parentService.findById(id);
        if(parent.isPresent()) {
            return ResponseEntity.ok(ApiResponse.success(parent.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ParentResponse>> save(@Valid @RequestBody ParentUpsertRequest req) {
        return ResponseEntity.ok(ApiResponse.success(parentService.save(req)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<ParentResponse>> update(@PathVariable("id") Long id,
                                                              @Valid @RequestBody ParentUpsertRequest req) {
        return ResponseEntity.ok(ApiResponse.success(parentService.update(id, req)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable("id") Long id) {
        parentService.delete(id);
        return ResponseEntity.ok(ApiResponse.successMessage("Success"));
    }
}
