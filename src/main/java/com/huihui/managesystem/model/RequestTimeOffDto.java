package com.huihui.managesystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record RequestTimeOffDto(
        @JsonProperty("employee_id") Long employeeId,
        @JsonProperty("start_time") LocalDateTime startTime,
        @JsonProperty("end_time") LocalDateTime endTime
) {
}
