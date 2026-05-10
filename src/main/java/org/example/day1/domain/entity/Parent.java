package org.example.day1.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.example.day1.domain.AuditableEntity;

@Entity
@Table(name = "parents")
@Data
public class Parent extends AuditableEntity {
    @Column(name = "full_name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String fullName;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false, unique = true)
    private String phone;

    @Column(columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(columnDefinition = "VARCHAR(255)")
    private String address;

    @Column(length = 20)
    private String relationship;

    @Column(length = 10)
    private String gender;
}
