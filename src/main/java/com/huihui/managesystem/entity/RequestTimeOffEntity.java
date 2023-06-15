package com.huihui.managesystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


@Table("request_time_off")
public record RequestTimeOffEntity(
        @Id Long id,
        Long employeeId,
        LocalDateTime startTime,
        LocalDateTime endTime
) {
}
