package com.sparta.schedule.dto;

import com.sparta.schedule.entity.Schedule;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data // @Getter /@Setter /@ToString /@RequireArgConstructor
// DTO = Data Transfer Object
public class ScheduleRequestDto {

    private String task; // 할일
    private String name; // 담당자면
    private String password; // 비밀번호


    @Builder
    public ScheduleRequestDto(String task, String name, String password) {
        this.task = task;
        this.name = name;
        this.password = password;
    }
}
