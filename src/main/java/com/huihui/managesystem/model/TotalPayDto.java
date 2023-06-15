package com.huihui.managesystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TotalPayDto(
        Long employeeId,
        Double totalWorkingTime,
        Double totalPay
) {
}
