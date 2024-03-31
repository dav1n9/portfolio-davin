package com.davin.portfolio.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class ExperienceDTO {
    private String title;
    private String description;
    private String startYearMonth;
    private String endYearMonth;
    private List<String> details;
}
