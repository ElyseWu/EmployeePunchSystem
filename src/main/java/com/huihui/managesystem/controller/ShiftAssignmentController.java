package com.huihui.managesystem.controller;

import com.huihui.managesystem.model.ShiftAssignmentDto;
import com.huihui.managesystem.service.ShiftAssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShiftAssignmentController {
    private final ShiftAssignmentService shiftAssignmentService;
    public ShiftAssignmentController(ShiftAssignmentService shiftAssignmentService) {
        this.shiftAssignmentService = shiftAssignmentService;
    }

    @PostMapping("/assign")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void assignShift(@RequestBody ShiftAssignmentDto shiftAssignmentDto) {
        shiftAssignmentService.assignShiftByEmployeeId(shiftAssignmentDto.employeeId(), shiftAssignmentDto.startTime(), shiftAssignmentDto.endTime());
    }
}
