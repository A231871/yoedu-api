package org.example.day1.dto.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
    private Long id;

    @JsonProperty("course_code")
    private String courseCode;

    private String name;
    private String description;

    @JsonProperty("tuition_fee")
    private BigDecimal tuitionFee;

    private Integer totalSessions;
    private Boolean isActive;
}
