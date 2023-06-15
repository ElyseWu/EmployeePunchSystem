package com.huihui.managesystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Table("shift_assignment")
public record ShiftAssignmentEntity(
        @Id Long id,
        Long employeeId,
        LocalDateTime startTime,
        LocalDateTime endTime
) {
}
