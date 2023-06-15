package com.huihui.managesystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record ShiftAssignmentDto(
        @JsonProperty("employee_id") Long employeeId,
        @JsonProperty("start_time") LocalDateTime startTime,
        @JsonProperty("end_time") LocalDateTime endTime
) {
}
