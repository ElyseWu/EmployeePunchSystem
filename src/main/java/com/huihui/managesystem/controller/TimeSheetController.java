package com.huihui.managesystem.controller;

import com.huihui.managesystem.model.TimeSheetDto;
import com.huihui.managesystem.service.TimeSheetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeSheetController {
    private final TimeSheetService timeSheetService;

    public TimeSheetController(TimeSheetService timeSheetService) {
        this.timeSheetService = timeSheetService;
    }

    @GetMapping("/timeSheet/{employeeId}")
    public TimeSheetDto getCart(@PathVariable("employeeId") Long employeeId) {
        return timeSheetService.getTimeSheet(employeeId);
    }
}
