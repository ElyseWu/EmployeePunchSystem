package com.huihui.managesystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Table("punch_time")
public record PunchTimeEntity(
        @Id Long id,
        Long employeeId,
        LocalDateTime punchTime,
        String inOutOrBreak
) {
}
