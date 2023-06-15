package com.huihui.managesystem.repository;

import com.huihui.managesystem.entity.PunchTimeEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface PunchTimeRepository extends ListCrudRepository<PunchTimeEntity, Long> {

    List<PunchTimeEntity> getPunchTimeEntitiesByEmployeeId(Long employeeId);

}
