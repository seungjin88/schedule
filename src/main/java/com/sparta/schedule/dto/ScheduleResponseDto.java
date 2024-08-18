package com.sparta.schedule.dto;

import com.sparta.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ScheduleResponseDto {

    private Long id;
    private String task;
    private String name;
    private String password;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    public static ScheduleResponseDto from(Schedule schedule) {
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTask(),
                schedule.getName(),
                schedule.getPassword(),
                schedule.getRegDate(),
                schedule.getModDate()
        );
    }
}