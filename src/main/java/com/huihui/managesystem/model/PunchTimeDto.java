package com.huihui.managesystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record PunchTimeDto(
        @JsonProperty("employee_id") Long employeeId,
        @JsonProperty("punch_time") LocalDateTime punchTime,
        @JsonProperty("in_out_or_break") String inOutOrBreak
) {
}
