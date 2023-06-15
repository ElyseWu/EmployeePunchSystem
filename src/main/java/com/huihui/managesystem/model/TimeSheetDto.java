package com.huihui.managesystem.model;

import com.huihui.managesystem.entity.TimeSheetEntity;
import com.huihui.managesystem.entity.WorkingTimeEntity;

import java.util.List;

public record TimeSheetDto(
        Long id,
        Double totalWorkingTime,
        List<WorkingTimeEntity> workingTimes
) {
    public  TimeSheetDto(TimeSheetEntity entity, List<WorkingTimeEntity> workingTimes) {
        this(entity.id(), entity.totalWorkingTime(), workingTimes);
    }
}
