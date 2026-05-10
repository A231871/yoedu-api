package org.example.day1.dto.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseUpsertRequest {
    @JsonProperty("course_code")
    @NotBlank
    @Size(min = 2, max = 20)
    private String courseCode;

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @Size(max = 500)
    private String description;

    @JsonProperty("tuition_fee")
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal tuitionFee;

    @NotNull
    @Min(1)
    private Integer totalSessions;

    @NotNull
    private Boolean isActive;
}
