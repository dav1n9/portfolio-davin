package com.davin.portfolio.presentation.repository;

import com.davin.portfolio.domain.entity.*;
import com.davin.portfolio.domain.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PresentationRepository {
    private AchievementRepository achievementRepository;
    private ExperienceRepository experienceRepository;
    private IntroductionRepository introductionRepository;
    private LinkRepository linkRepository;
    private SkillRepository skillRepository;
    private ProjectRepository projectRepository;

    public List<Achievement> getActiveAchievements() {
        return achievementRepository.findAllByIsActive(true);
    }
    public List<Experience> getActiveExperiences() {
        return experienceRepository.findAllByIsActive(true);
    }
    public List<Introduction> getActiveIntroductions() {
        return introductionRepository.findAllByIsActive(true);
    }
    public List<Link> getActiveLinks() {
        return linkRepository.findAllByIsActive(true);
    }
    public List<Skill> getActiveSkills() {
        return skillRepository.findAllByIsActive(true);
    }
    public List<Project> getActiveProjects() {
        return projectRepository.findAllByIsActive(true);
    }
}
