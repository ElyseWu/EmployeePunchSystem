package com.huihui.managesystem.service;

import com.huihui.managesystem.entity.IsActiveEntity;
import com.huihui.managesystem.entity.RequestTimeOffEntity;
import com.huihui.managesystem.entity.ShiftAssignmentEntity;
import com.huihui.managesystem.repository.IsActiveRepository;
import com.huihui.managesystem.repository.RequestTimeOffRepository;
import com.huihui.managesystem.repository.ShiftAssignmentRepository;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class ShiftAssignmentService {
    private final ShiftAssignmentRepository shiftAssignmentRepository;
    private final IsActiveRepository isActiveRepository;
    private final RequestTimeOffRepository requestTimeOffRepository;

    public ShiftAssignmentService(ShiftAssignmentRepository shiftAssignmentRepository, IsActiveRepository isActiveRepository,
                                  RequestTimeOffRepository requestTimeOffRepository) {
        this.shiftAssignmentRepository = shiftAssignmentRepository;
        this.isActiveRepository = isActiveRepository;
        this.requestTimeOffRepository = requestTimeOffRepository;
    }

    public void assignShiftByEmployeeId(Long employeeId, LocalDateTime startTime, LocalDateTime endTime) {
        //1. check if this employee is active
        //2. if it is, check startTime and endTime has requestTime off (get all request time off and check overlap)
        //3. if not, assign shift
        IsActiveEntity isActive = isActiveRepository.getIsActiveEntityByEmployeeId(employeeId);
        if (!isActive.isActive()) {
           return ;
//            throw new Exception("oops, this employee is not exist");
        }
        List<RequestTimeOffEntity> requestTimeOffByThisEmployee = requestTimeOffRepository.getRequestTimeOffEntityByEmployeeId(employeeId);
        if (requestTimeOffByThisEmployee == null || hasNotOverLap(requestTimeOffByThisEmployee, startTime, endTime)) {
            //we can assign shift to this employee
            ShiftAssignmentEntity newShift = new ShiftAssignmentEntity(null, employeeId, startTime, endTime);
            shiftAssignmentRepository.save(newShift);
        }
    }

    private boolean hasNotOverLap(List<RequestTimeOffEntity> requests, LocalDateTime start, LocalDateTime end) {
        //check request and [start, end] has overlap
        Collections.sort(requests, (a, b) ->(a.startTime().compareTo(b.startTime())));
        for (RequestTimeOffEntity request : requests) {
            if (request.endTime().isBefore(start)) {
                continue;
            } else if (request.startTime().isAfter(end)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
