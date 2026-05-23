package org.example.day1.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.day1.common.ApiResponse;
import org.example.day1.dto.room.RoomResponse;
import org.example.day1.dto.room.RoomUpsertResponse;
import org.example.day1.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/rooms")
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ResponseEntity<ApiResponse<List<RoomResponse>>> findAll() {
        return ResponseEntity.ok(ApiResponse.success(roomService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<RoomResponse>> findById(@PathVariable("id") Long id) {
        Optional<RoomResponse> room = roomService.findById(id);
        if(room.isPresent()) {
            return ResponseEntity.ok(ApiResponse.success(room.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<RoomResponse>> save(@Valid @RequestBody RoomUpsertResponse req) {
        return ResponseEntity.ok(ApiResponse.success(roomService.save(req)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<RoomResponse>> update(@PathVariable("id") Long id,
                                                            @Valid @RequestBody RoomUpsertResponse req) {
        return ResponseEntity.ok(ApiResponse.success(roomService.save(id, req)));
    }
}
