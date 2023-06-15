package com.huihui.managesystem.controller;

import com.huihui.managesystem.model.RequestTimeOffDto;
import com.huihui.managesystem.service.RequestTimeOffService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class RequestTimeOffController {
    //需要前端传来start time, end time, employee id
    private final RequestTimeOffService requestTimeOffService;

    public RequestTimeOffController(RequestTimeOffService requestTimeOffService) {
        this.requestTimeOffService = requestTimeOffService;
    }

    @PostMapping("/requestTimeOff")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void requestTimeOff(@RequestBody RequestTimeOffDto requestTimeOffDto) {
        requestTimeOffService.requestTimeOff(requestTimeOffDto.employeeId(), requestTimeOffDto.startTime(), requestTimeOffDto.endTime());
    }
}
