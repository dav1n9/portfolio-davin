package com.davin.portfolio.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class AchievementDTO {
    private String title;
    private String description;
    private String achievedDate;
    private String host;
}
