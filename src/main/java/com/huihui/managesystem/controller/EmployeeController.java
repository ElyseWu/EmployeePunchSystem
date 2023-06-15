package com.huihui.managesystem.controller;

import com.huihui.managesystem.entity.EmployeeEntity;
import com.huihui.managesystem.model.RegisterBody;
import com.huihui.managesystem.service.EmployeeService;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private  final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //getEmployeeById
    //createEmployee
    //updateEmployee
    //deleteEmployee
    //request time off
    //punch
    //manager: get timesheet
    //manager: pay
    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createEmployee(@RequestBody RegisterBody body) {
        employeeService.create(body.email(), body.password(), body.firstName(), body.lastName(), body.role());
    }

    @GetMapping("/employee/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable("employeeId") Long employeeId)throws Exception{
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("/update/{employeeId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateEmployee(@PathVariable Long employeeId, @RequestBody RegisterBody body){
        employeeService.updateEmployeeById(employeeId, body.email(), body.firstName(), body.lastName(), body.role());
    }

    @PutMapping("/delete/{employeeId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteEmployee(@PathVariable Long employeeId) {

        employeeService.deleteEmployee(employeeId);
    }

}
