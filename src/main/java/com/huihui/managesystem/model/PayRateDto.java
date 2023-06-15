package com.huihui.managesystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PayRateDto(
        @JsonProperty("employee_id") Long employeeId,
        @JsonProperty("pay_rate") Double payRate,
        @JsonProperty("over_time_pay_rate") Double overPayRate
) {
}
