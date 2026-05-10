package org.example.day1.dto.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.day1.domain.enums.TeacherRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResponse {
    private Long id;
    private String teacherCode;
    private String fullName;
    private String phone;
    private String email;
    private TeacherRole teacherRole;
    private String cccdImageUrl;
    private Boolean isActive;
}
