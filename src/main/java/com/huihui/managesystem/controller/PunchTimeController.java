package com.huihui.managesystem.controller;

import com.huihui.managesystem.model.PunchTimeDto;
import com.huihui.managesystem.model.RegisterBody;
import com.huihui.managesystem.service.PunchTimeService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class PunchTimeController {
    private final PunchTimeService punchTimeService;

    public PunchTimeController(PunchTimeService punchTimeService) {
        this.punchTimeService = punchTimeService;
    }

    @PostMapping("/punch")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void punchTimeByEmployeeId(@RequestBody PunchTimeDto punchTimeDto) {
        punchTimeService.createEmployeePunch(punchTimeDto.employeeId(), punchTimeDto.punchTime(), punchTimeDto.inOutOrBreak());
    }
}
