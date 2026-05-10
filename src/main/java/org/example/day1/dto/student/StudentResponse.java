package org.example.day1.dto.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.day1.domain.enums.Gender;
import org.example.day1.domain.enums.StudentStatus;
import org.example.day1.dto.parent.ParentResponse;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private long id;
    private String studentCode;
    private String fullName;
    private LocalDate dateOfBirth;
    private Gender gender = Gender.OTHER;
    private String gradeLevel;
    private String schoolName;
    private String phone;
    private ParentResponse parent;
    private StudentStatus status = StudentStatus.ACTIVE;
    private BigDecimal latestScore = BigDecimal.ZERO;
    private String note;
}
