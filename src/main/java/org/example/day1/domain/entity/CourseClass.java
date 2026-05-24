package org.example.day1.domain.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.example.day1.domain.AuditableEntity;
import org.example.day1.domain.enums.ClassStatus;

import java.time.LocalDate;

@Entity
@Data
@Table(name ="course_classes")
public class CourseClass extends AuditableEntity {

    @Column(columnDefinition = "varchar(20)")
    private String codeCode;

    @Column(columnDefinition = "varchar(255)")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule_slot_id", nullable = false)
    private ScheduleSlot slot;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "main_teacher_id", nullable = false)
    private Teacher mainTeacher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assistant_teacher_id")
    private Teacher assistantTeacher;

    private LocalDate startDate;
    private LocalDate endDate;

    private int maxStudents;

    @Column(columnDefinition = "DECIMAL(12,2)")
    private double tuitionFee;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ClassStatus status = ClassStatus.OPEN;
}
