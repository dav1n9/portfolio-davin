package com.davin.portfolio.presentation.dto;

import com.davin.portfolio.domain.entity.Achievement;
import com.davin.portfolio.domain.entity.Experience;
import com.davin.portfolio.domain.entity.ExperienceDetail;
import com.davin.portfolio.domain.entity.Skill;
import lombok.Getter;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
public class ResumeDTO {
    private final List<ExperienceDTO> experiences;
    private final List<AchievementDTO> achievements;
    private final List<SkillDTO> skills;

    public ResumeDTO(List<Experience> experiences, List<Achievement> achievements, List<Skill> skills) {
        this.experiences = experiences.stream().map(e -> ExperienceDTO.builder()
                .title(e.getTitle())
                .description(e.getDescription())
                .startYearMonth(e.getStartYear() + "." + e.getStartMonth())
                .endYearMonth(e.getEndYearMonth())
                .details(e.getDetails().stream().filter(ExperienceDetail::isActive).map(ExperienceDetail::getContent).toList())
                .build()).toList();
        this.achievements = achievements.stream().map(achievement -> AchievementDTO.builder()
                .title(achievement.getTitle())
                .description(achievement.getDescription())
                .host(achievement.getHost())
                .achievedDate(achievement.getAchievedDate() == null ? null
                        : achievement.getAchievedDate().format(DateTimeFormatter.ISO_LOCAL_DATE).replace("-", "."))
                .build()).toList();

        this.skills = skills.stream().map(SkillDTO::new).toList();
    }
}
