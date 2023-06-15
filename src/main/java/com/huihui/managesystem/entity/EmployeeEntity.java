package com.huihui.managesystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("employees")
public record EmployeeEntity(
        @Id Long id,
        String email,
        String password,
        boolean enabled,
        String firstName,
        String lastName,
        String role
) {
}
