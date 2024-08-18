package com.sparta.schedule.repository;

import com.sparta.schedule.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;

@Repository
public class ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 1단계 일정 작성

    public /* 변수 타입 */ Schedule createSchedule(Schedule schedule) {
        String sql = "INSERT INTO schedule(task, name, password, regDate, modDate) VALUES(?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        LocalDateTime currentTime = LocalDateTime.now();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, schedule.getTask());
            ps.setString(2, schedule.getName());
            ps.setString(3, schedule.getPassword());
            ps.setObject(4, schedule.getRegDate());
            ps.setObject(5, schedule.getModDate());
            return ps;
        }, keyHolder);
        Long newId = Objects.requireNonNull(keyHolder.getKey()).longValue();
        return Schedule.builder()
                .id(newId)
                .task(schedule.getTask())
                .name(schedule.getName())
                .password(schedule.getPassword())
                .regDate(currentTime)
                .modDate(currentTime)
                .build();
    }

        private static class SchedulRowMapper implements RowMapper<Schedule> {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Schedule.builder()
                        .id(rs.getLong("id"))
                        .task(rs.getString("task"))
                        .name(rs.getString("name"))
                        .password(rs.getString("password"))
                        .regDate(rs.getTimestamp("regDate").toLocalDateTime())
                        .modDate(rs.getTimestamp("modDate").toLocalDateTime())
                        .build();
            }
        }
    }
