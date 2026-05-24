package org.example.day1.dto.attendance;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AttendanceResponse {
    private Long id;
    private Long courseClassId;
    private String className;
    private Long studentId;
    private String studentName;
    private LocalDate attendanceDate;
    private String status;
    private String note;
    private Long recordedByUserId;
    private String recordedByUsername;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
