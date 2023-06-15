package com.huihui.managesystem.repository;

import com.huihui.managesystem.entity.TimeSheetEntity;
import com.huihui.managesystem.entity.WorkingTimeEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface TimeSheetRepository extends ListCrudRepository<TimeSheetEntity, Long> {
    TimeSheetEntity getByEmployeeId(Long employeeId);

    @Modifying
    @Query("UPDATE time_sheet SET total_working_time = :totalWorkingTime WHERE id = :timeSheetId")
    void updateTotalWorkingTime(Long timeSheetId, Double totalWorkingTime);
}
