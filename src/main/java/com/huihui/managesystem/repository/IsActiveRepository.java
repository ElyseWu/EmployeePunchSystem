package com.huihui.managesystem.repository;

import com.huihui.managesystem.entity.EmployeeEntity;
import com.huihui.managesystem.entity.IsActiveEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface IsActiveRepository extends ListCrudRepository<IsActiveEntity, Long> {

    @Modifying
    @Query("UPDATE is_active SET is_active = false WHERE employee_id = :employeeId")
    void setIsActiveFalse(Long employeeId);

    IsActiveEntity getIsActiveEntityByEmployeeId(Long employeeId);
}
