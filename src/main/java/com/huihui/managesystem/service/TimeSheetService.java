package com.huihui.managesystem.service;

import com.huihui.managesystem.entity.PunchTimeEntity;
import com.huihui.managesystem.entity.TimeSheetEntity;
import com.huihui.managesystem.entity.WorkingTimeEntity;
import com.huihui.managesystem.model.TimeSheetDto;
import com.huihui.managesystem.repository.PunchTimeRepository;
import com.huihui.managesystem.repository.TimeSheetRepository;
import com.huihui.managesystem.repository.WorkingTimeRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSheetService {
    private final TimeSheetRepository timeSheetRepository;
    private final PunchTimeRepository punchTimeRepository;
    private final WorkingTimeRepository workingTimeRepository;

    public TimeSheetService (TimeSheetRepository timeSheetRepository, PunchTimeRepository punchTimeRepository,
                             WorkingTimeRepository workingTimeRepository) {
        this.timeSheetRepository = timeSheetRepository;
        this.punchTimeRepository = punchTimeRepository;
        this.workingTimeRepository = workingTimeRepository;
    }

    @Cacheable("timeSheet")
    public TimeSheetDto getTimeSheet(Long employeeId) {
        //get TimeSheetDto: id, total working time and list of working time entity
        //timesheetEntity can
        TimeSheetEntity timeSheet = timeSheetRepository.getByEmployeeId(employeeId);
        List<WorkingTimeEntity> workingTimes = workingTimeRepository.getWorkingTimeEntitiesByEmployeeId(employeeId);

        return new TimeSheetDto(timeSheet, workingTimes);
    }
}
