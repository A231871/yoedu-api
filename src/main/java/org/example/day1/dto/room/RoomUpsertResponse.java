package org.example.day1.dto.room;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
    public class RoomUpsertResponse {
    @NotBlank
    @Size(min = 2, max = 20)
    private String room_code;

    @NotBlank
    @Size(min = 2,  max = 100)
    private String name;

    @NotNull
    @Min(1)
    private int capacity;

    @Size(max = 255)
    private String description;
}
