package com.huihui.managesystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("total_pay")
public record TotalPayEntity(
        @Id Long id,
        Long employeeId,
        Double totalPay
) {
}
