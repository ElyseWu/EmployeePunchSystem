package com.huihui.managesystem.service;

import com.huihui.managesystem.entity.EmployeeEntity;
import com.huihui.managesystem.entity.PunchTimeEntity;
import com.huihui.managesystem.entity.TimeSheetEntity;
import com.huihui.managesystem.entity.WorkingTimeEntity;
import com.huihui.managesystem.repository.PunchTimeRepository;
import com.huihui.managesystem.repository.TimeSheetRepository;
import com.huihui.managesystem.repository.WorkingTimeRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PunchTimeService {
    private final PunchTimeRepository punchTimeRepository;
    private  final WorkingTimeRepository workingTimeRepository;
    private  final TimeSheetRepository timeSheetRepository;

    public PunchTimeService(PunchTimeRepository punchTimeRepository, WorkingTimeRepository workingTimeRepository,
                            TimeSheetRepository timeSheetRepository) {
        this.punchTimeRepository = punchTimeRepository;
        this.workingTimeRepository = workingTimeRepository;
        this.timeSheetRepository = timeSheetRepository;
    }

    @Transactional
    public void createEmployeePunch(Long employeeId, LocalDateTime punchTime, String inOutOrBreak) {
        //check if we need to caculate working hours from last time and store into time sheet
        if (inOutOrBreak.equals("break") || inOutOrBreak.equals("out")) {
            //we need to caculate working hours between last time punch and this time punch
            //and store the information in working_time table
            //time sheet is the total working time
            List<PunchTimeEntity> punchTimes = punchTimeRepository.getPunchTimeEntitiesByEmployeeId(employeeId);
            PunchTimeEntity prev = punchTimes.get(punchTimes.size() -1);
            Duration duration = Duration.between(prev.punchTime(), punchTime);
            long workingTimeInMin = duration.toMinutes();
            Double workingTime = workingTimeInMin/60.0;
            WorkingTimeEntity newWorkingTimeEntity = new WorkingTimeEntity(null, employeeId, workingTime);
            workingTimeRepository.save(newWorkingTimeEntity);
            TimeSheetEntity timeSheet = timeSheetRepository.getByEmployeeId(employeeId);
            timeSheetRepository.updateTotalWorkingTime(timeSheet.id(), timeSheet.totalWorkingTime() + workingTime);
        }

        //create a new punch record in punch time table
        PunchTimeEntity newPunchTime = new PunchTimeEntity(null, employeeId, punchTime, inOutOrBreak);
        punchTimeRepository.save(newPunchTime);
    }

}
