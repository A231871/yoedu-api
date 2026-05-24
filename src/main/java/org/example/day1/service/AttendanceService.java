package org.example.day1.service;

import org.example.day1.common.exception.BadRequestException;
import org.example.day1.common.exception.NotFoundException;
import org.example.day1.dto.attendance.AttendanceCreateRequest;
import org.example.day1.dto.attendance.AttendanceResponse;

import java.util.List;

public interface AttendanceService {
    AttendanceResponse create(AttendanceCreateRequest request, String username)
            throws BadRequestException, NotFoundException;

    List<AttendanceResponse> findByClassId(Long classId) throws NotFoundException;
}
