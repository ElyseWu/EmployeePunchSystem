package com.huihui.managesystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("working_time")
public record WorkingTimeEntity(
        @Id Long id,
        Long employeeId,
        Double workingTime
) {
}
