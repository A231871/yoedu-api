package org.example.day1.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.day1.domain.AuditableEntity;
import org.example.day1.domain.enums.Gender;
import org.example.day1.domain.enums.StudentStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "students")
@Data
public class Student extends AuditableEntity {
    @Column(name = "student_code", columnDefinition = "VARCHAR(20)", nullable = false, unique = true)
    private String studentCode;

    @Column(name = "full_name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Gender gender = Gender.OTHER;

    @Column(name = "grade_level", columnDefinition = "VARCHAR(30)")
    private String gradeLevel;

    @Column(name = "school_name", columnDefinition = "VARCHAR(100)")
    private String schoolName;

    @Column(columnDefinition = "VARCHAR(20)")
    private String phone;
    // <- EAGER: Load tat ca data trong bang cung 1 luc, LAZY: Khi su dung moi load
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StudentStatus status = StudentStatus.ACTIVE;

    @Column(name = "latest_score", columnDefinition = "DECIMAL(5,2)")
    private BigDecimal latestScore = BigDecimal.ZERO;

    @Column(columnDefinition = "VARCHAR(255)")
    private String note;
}
