package com.huihui.managesystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("time_sheet")
public record TimeSheetEntity(
        @Id Long id,
        Long employeeId,
        Double totalWorkingTime
) {
}
