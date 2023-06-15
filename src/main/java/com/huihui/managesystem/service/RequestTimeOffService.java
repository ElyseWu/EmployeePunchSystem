package com.huihui.managesystem.service;

import com.huihui.managesystem.entity.RequestTimeOffEntity;
import com.huihui.managesystem.repository.RequestTimeOffRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RequestTimeOffService {
    private final RequestTimeOffRepository requestTimeOffRepository;

    public RequestTimeOffService(RequestTimeOffRepository requestTimeOffRepository) {
        this.requestTimeOffRepository = requestTimeOffRepository;
    }
    public void requestTimeOff(Long employeeId, LocalDateTime startTime, LocalDateTime endTime) {
        RequestTimeOffEntity newRequest = new RequestTimeOffEntity(null, employeeId, startTime, endTime);
        requestTimeOffRepository.save(newRequest);
    }
}
