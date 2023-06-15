package com.huihui.managesystem.repository;

import com.huihui.managesystem.entity.PayRateEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PayRateRepository extends ListCrudRepository<PayRateEntity, Long> {
    PayRateEntity getPayRateEntityByEmployeeId(Long employeeId);
}
