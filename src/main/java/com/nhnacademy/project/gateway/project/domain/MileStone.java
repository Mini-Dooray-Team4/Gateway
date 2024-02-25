package com.nhnacademy.project.gateway.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MileStone {
    private Integer mileStoneId;
    private String mileStoneName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Project project;
}
