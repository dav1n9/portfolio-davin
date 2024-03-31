package com.davin.portfolio.presentation.dto;

import com.davin.portfolio.domain.entity.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SkillDTO {
    private String name;
    private String type;

    public SkillDTO(Skill skill) {
        name = skill.getName();
        type = skill.getType().name();
    }
}
