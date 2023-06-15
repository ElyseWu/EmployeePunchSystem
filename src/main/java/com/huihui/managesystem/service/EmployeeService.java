package com.huihui.managesystem.service;

import com.huihui.managesystem.entity.EmployeeEntity;
import com.huihui.managesystem.entity.IsActiveEntity;
import com.huihui.managesystem.entity.TimeSheetEntity;
import com.huihui.managesystem.repository.EmployeeRepository;
import com.huihui.managesystem.repository.IsActiveRepository;
import com.huihui.managesystem.repository.TimeSheetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final IsActiveRepository isActiveRepository;
    private final TimeSheetRepository timeSheetRepository;

    public EmployeeService(EmployeeRepository employeeRepository, IsActiveRepository isActiveRepository,
                           TimeSheetRepository timeSheetRepository) {
        this.employeeRepository = employeeRepository;
        this.isActiveRepository = isActiveRepository;
        this.timeSheetRepository = timeSheetRepository;
    }

    @Transactional
    public void create(String email, String password, String firstName, String lastName,
                       String role) {
        //1. create new emoloyee into employee table
        //2. create new isActive into isActive table
        //3. create a timesheet row to this new employee
        email = email.toLowerCase();
//        UserDetails user = User.builder()
//                .username(email)
//                .password(passwordEncoder.encode(password))
//                .roles(role)
//                .build();
//        userDetailsManager.createUser(user);
        EmployeeEntity newEmployee = new EmployeeEntity(null, email,password, true, firstName, lastName, role);
        employeeRepository.save(newEmployee);
//        employeeRepository.updateNameByEmail(email, firstName, lastName, role);

        EmployeeEntity savedEmployee = employeeRepository.getEmployeeEntityByEmail(email);
        IsActiveEntity newIsActive = new IsActiveEntity(null, savedEmployee.id(), true);
        isActiveRepository.save(newIsActive);

        TimeSheetEntity timeSheet = new TimeSheetEntity(null, savedEmployee.id(), 0.0);
        timeSheetRepository.save(timeSheet);
    }

    public EmployeeEntity getEmployeeById(Long employeeId) throws Exception {
//        Optional res = employeeRepository.findById(employeeId);
//        if (res == null) {
//            throw new Exception("unfound id");
//        } else {
//            return (EmployeeEntity) res.get();
//        }
        return employeeRepository.getEmployeeEntityById(employeeId);
    }

    public void updateEmployeeById(Long employeeId, String email, String firstName, String lastName, String role) {
        employeeRepository.updateNameByEmail(employeeId, email, firstName, lastName, role);
    }

    public void deleteEmployee(Long employeeId) {
        //I need to change isActiveRepository
        isActiveRepository.setIsActiveFalse(employeeId);
    }
}
