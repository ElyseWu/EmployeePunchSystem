package com.huihui.managesystem.repository;

import com.huihui.managesystem.entity.RequestTimeOffEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface RequestTimeOffRepository  extends ListCrudRepository<RequestTimeOffEntity, Long> {
    List<RequestTimeOffEntity> getRequestTimeOffEntityByEmployeeId(Long employeeId);
}
