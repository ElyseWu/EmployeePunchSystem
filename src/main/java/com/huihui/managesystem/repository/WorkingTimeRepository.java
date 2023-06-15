package com.huihui.managesystem.repository;

import com.huihui.managesystem.entity.PunchTimeEntity;
import com.huihui.managesystem.entity.WorkingTimeEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface WorkingTimeRepository extends ListCrudRepository<WorkingTimeEntity, Long> {
    List<WorkingTimeEntity> getWorkingTimeEntitiesByEmployeeId(Long employeeId);
}
