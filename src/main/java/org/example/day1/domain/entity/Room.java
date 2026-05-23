package org.example.day1.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.example.day1.domain.AuditableEntity;

@Entity
@Data
@Table(name = "rooms")
public class Room  extends AuditableEntity {

    @Column(columnDefinition = "varchar(20)")
    private String room_code;

    @Column(columnDefinition = "varchar(100)")
    private String name;


    private int capacity;

    @Column(columnDefinition = "varchar(255)")
    private String description;
}
