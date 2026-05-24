package org.example.day1.dto.attendance;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.day1.domain.entity.Attendance;
import org.example.day1.domain.enums.AttendanceStatus;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceCreateRequest {
    @NotNull
    Long courseClassId;
    @NotNull
    Long studentId;
    @NotNull
    LocalDate attendanceDate;
    @NotNull
    AttendanceStatus status;
    @Size(max = 255)
    String note;
}
