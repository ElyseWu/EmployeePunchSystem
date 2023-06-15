package com.huihui.managesystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("is_active")
public record IsActiveEntity(
        @Id Long id,
        Long employeeId,
        boolean isActive
) {
}
