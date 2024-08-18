package com.sparta.schedule.Service;

import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.Schedule;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {
    Schedule createSchedule(ScheduleRequestDto scheduleRequestDto);

    ScheduleResponseDto getSchedule(Long id);

    List<Schedule> getScheduleByNameAndMadDate(String name, LocalDate modDate);

    Schedule updateScheduleByTaskAndName(Long id, ScheduleRequestDto scheduleRequestDto);

    void deleteScheduleById(Long id);
}