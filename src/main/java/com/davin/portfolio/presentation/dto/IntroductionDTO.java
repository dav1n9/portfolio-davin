package com.davin.portfolio.presentation.dto;

import com.davin.portfolio.domain.entity.Introduction;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IntroductionDTO {
    private String content;

    public IntroductionDTO(Introduction introduction) {
        content = introduction.getContent();
    }
}
