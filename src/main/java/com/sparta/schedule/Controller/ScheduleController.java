package com.sparta.schedule.Controller;

import com.sparta.schedule.Service.ScheduleService;
import com.sparta.schedule.Service.ScheduleServiceImpl;
import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
@Slf4j
public class ScheduleController {
    private final ScheduleServiceImpl scheduleServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<Schedule> createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        log.info("Register schedule request: {}", scheduleRequestDto);
        return ResponseEntity.ok(scheduleServiceImpl.createSchedule(scheduleRequestDto));
    }

    @GetMapping("{id}") // id 값으로 조회를 할 예정
    public ResponseEntity<ScheduleResponseDto> getById(@PathVariable long id) {
        if(scheduleServiceImpl.getSchedule(id)== null) {
            return ResponseEntity.notFound().build();
        }
        log.info("Get by id: {}", id);
        return ResponseEntity.ok(scheduleServiceImpl.getSchedule(id));
    }
}