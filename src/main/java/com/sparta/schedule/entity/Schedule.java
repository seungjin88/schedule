package com.sparta.schedule.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Timestamp;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter // 각 필드 값을 조회 할 수 있는 getter 들을 자동으로 생성해준다
        // 예를 들어서 다른 파일들에서 Schedule 객체의 id값을 얻고 싶다면 getId메소드를 정의해서 해당 객체의 Id값을 얻어와야 하는데
        // 해당 method를 작성하지 않아도 자동으로 생성해준다.
@NoArgsConstructor
// 파라미터가 아예 없는 기본생성자를 자동으로 만들어준다.
@ToString
// 해당 Class에 선언된 필드들을 모두 출력할 수 있는 toString 메소드를 자동으로 생성할 수 있도록 만들어 준다.
public class Schedule {

    private Long id; // Schedule 테이블의 고유 식별사 선언
    private String task; // 할일
    private String name; // 담당자면

    @JsonIgnore
    private String password; // 비밀번호

    @Timestamp
    private LocalDateTime regDate; // 생성일

    @Timestamp
    private LocalDateTime modDate; // 수정일

    @Builder
    public Schedule(Long id, String task, String name, String password, LocalDateTime regDate, LocalDateTime modDate) {
        this.id = id;
        this.task = task;
        this.name = name;
        this.password = password;
        this.regDate = regDate;
        this.modDate = modDate;
    }
}
