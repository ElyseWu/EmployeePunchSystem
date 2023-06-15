package com.huihui.managesystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("pay_rate")
public record PayRateEntity(
        @Id Long id,
        Long employeeId,
        Double payRate,
        Double overPayRate
) {
}
