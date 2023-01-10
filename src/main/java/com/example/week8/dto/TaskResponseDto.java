package com.example.week8.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TaskResponseDto {
    private Long taskId;
    private Long userId;
}
