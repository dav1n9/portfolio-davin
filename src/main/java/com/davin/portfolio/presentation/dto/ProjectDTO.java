package com.davin.portfolio.presentation.dto;

import com.davin.portfolio.domain.entity.Project;
import com.davin.portfolio.domain.entity.ProjectDetail;
import com.davin.portfolio.domain.entity.ProjectSkill;
import com.davin.portfolio.domain.entity.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ProjectDTO {
    private String name;
    private String description;
    private String startYearMonth;
    private String endYearMonth;
    private List<ProjectDetailDTO> details;
    private List<SkillDTO> skills;

    public ProjectDTO(Project project) {
        name = project.getName();
        description = project.getDescription();
        startYearMonth = project.getStartYear() + "." + project.getStartMonth();
        endYearMonth = project.getEndYearMonth();
        details = project.getDetails().stream()
                .filter(ProjectDetail::isActive)
                .map(ProjectDetailDTO::new).toList();
        skills = project.getSkills().stream()
                .map(ProjectSkill::getSkill)
                .filter(Skill::getIsActive)
                .map(SkillDTO::new).toList();
    }
}
