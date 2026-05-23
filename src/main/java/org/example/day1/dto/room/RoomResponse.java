package org.example.day1.dto.room;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RoomResponse {

    private Long id;

    private String room_code;

    private String name;

    private int capacity;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
