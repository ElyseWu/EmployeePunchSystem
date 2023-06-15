package com.huihui.managesystem.controller;

import com.huihui.managesystem.model.PayRateDto;
import com.huihui.managesystem.model.PunchTimeDto;
import com.huihui.managesystem.model.TotalPayDto;
import com.huihui.managesystem.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {
    //manager: 1. set pay rate, 2. every week send payment to employee
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    //1. set pay rate
    @PostMapping("/payRate")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void setPayRateByEmployeeId(@RequestBody PayRateDto payRateDto) {
        paymentService.setPayRate(payRateDto.employeeId(), payRateDto.payRate(), payRateDto.overPayRate());
    }

    //2. send payment to employee
    //return a total payment dto to user, including employee id and payment number
    @PostMapping("/pay/{employeeId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public TotalPayDto payToEmployeeByEmployeeID(@PathVariable("employeeId") Long employeeId) {
        return paymentService.payToEmployee(employeeId);
    }
}
