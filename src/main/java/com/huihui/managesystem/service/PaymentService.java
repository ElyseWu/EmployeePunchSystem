package com.huihui.managesystem.service;

import com.huihui.managesystem.entity.PayRateEntity;
import com.huihui.managesystem.entity.TimeSheetEntity;
import com.huihui.managesystem.model.TotalPayDto;
import com.huihui.managesystem.repository.PayRateRepository;
import com.huihui.managesystem.repository.TimeSheetRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PayRateRepository payRateRepository;
    private final TimeSheetRepository timeSheetRepository;

    public PaymentService(PayRateRepository payRateRepository, TimeSheetRepository timeSheetRepository) {

        this.payRateRepository = payRateRepository;
        this.timeSheetRepository = timeSheetRepository;
    }

    public void setPayRate(Long employeeId, Double payRate, Double overTimePayRate) {
        PayRateEntity payRateEntity = new PayRateEntity(null, employeeId, payRate, overTimePayRate);
        payRateRepository.save(payRateEntity);
    }

    public TotalPayDto payToEmployee(Long employeeId) {
        //1. according employeeId, get payRate and overTimePayRate from PayRateEntity and get totalWorkingTime form timeSheetEntity
        //2. caculate totalpay
        PayRateEntity payRateEntity = payRateRepository.getPayRateEntityByEmployeeId(employeeId);
        Double payRate = payRateEntity.payRate();
        Double overPayRate = payRateEntity.overPayRate();

        TimeSheetEntity timeSheetEntity = timeSheetRepository.getByEmployeeId(employeeId);
        Double totalWorkingTIme = timeSheetEntity.totalWorkingTime();

        Double totalPay = 0.0;
        if (totalWorkingTIme <= 40) {
            totalPay = totalWorkingTIme * payRate;
        } else {
            totalPay = payRate * 40 + overPayRate * (totalWorkingTIme - 40);
        }

        return new TotalPayDto(employeeId, totalWorkingTIme, totalPay);
    }
}
