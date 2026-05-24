package org.example.day1.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.day1.common.ApiResponse;
import org.example.day1.dto.attendance.AttendanceCreateRequest;
import org.example.day1.dto.attendance.AttendanceResponse;
import org.example.day1.service.AttendanceService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/api/attendances")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','ACADEMIC_STAFF')")
    public ApiResponse<AttendanceResponse> create(@Valid @RequestBody
                                                      AttendanceCreateRequest request, Principal principal) {
        return ApiResponse.success("Attendance created", attendanceService.create(request, principal.getName()));
    }

    @GetMapping("/class/{classId}")
    @PreAuthorize("hasAnyRole('ADMIN','ACADEMIC_STAFF')")
    public ApiResponse<List<AttendanceResponse>> findByClassId(@PathVariable Long classId) {
        return ApiResponse.success(attendanceService.findByClassId(classId));
    }
}
