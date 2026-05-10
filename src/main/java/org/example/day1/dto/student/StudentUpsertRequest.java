package org.example.day1.dto.student;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.day1.domain.enums.Gender;
import org.example.day1.domain.enums.StudentStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpsertRequest {
    @NotBlank @Size(min = 2, max = 20) String studentCode;
    @NotBlank @Size(min = 2,  max = 100) String fullName;
    LocalDate dateOfBirth; //Xu ly validate sau (Hien @valid ko xu ly)
    @NotNull Gender gender;
    @Size(max = 30) String gradeLevel;
    @Size(max = 100) String schoolName;
    @Pattern(regexp = "^(84|0[3|5|7|8|9])+([0-9]{8})$") @Size(max = 20) @Nullable String phone;
    Long parentId;
    @NotNull StudentStatus status;
    @NotNull @DecimalMin("0.0") @DecimalMax ("10.0") BigDecimal latestScore;
    @Size(max = 255) String note;
}
