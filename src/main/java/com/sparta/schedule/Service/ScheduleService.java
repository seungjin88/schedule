package com.sparta.schedule.Service;

import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.entity.Schedule;

public interface ScheduleService {
    Schedule createSchedule(ScheduleRequestDto scheduleRequestDto);
}
