package org.example.day1.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import org.example.day1.domain.AuditableEntity;
import org.example.day1.domain.enums.TeacherRole;

@Entity
@Table(name = "teachers")
@Data
public class Teacher extends AuditableEntity {
    @Column(name = "teacher_code", columnDefinition = "VARCHAR(20)", nullable = false, unique = true)
    private String teacherCode;

    @Column(name = "full_name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String fullName;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false, unique = true)
    private String phone;

    @Column(columnDefinition = "VARCHAR(100)")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TeacherRole teacherRole = TeacherRole.TEACHER;

    @Column(name = "cccd_image_url", columnDefinition = "VARCHAR(255)")
    private String cccdImageUrl;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
