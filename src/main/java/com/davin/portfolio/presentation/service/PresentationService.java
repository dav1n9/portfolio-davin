package com.davin.portfolio.presentation.service;

import com.davin.portfolio.domain.entity.*;
import com.davin.portfolio.presentation.dto.IntroductionDTO;
import com.davin.portfolio.presentation.dto.LinkDTO;
import com.davin.portfolio.presentation.dto.ProjectDTO;
import com.davin.portfolio.presentation.dto.ResumeDTO;
import com.davin.portfolio.presentation.repository.PresentationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PresentationService {
    private final PresentationRepository presentationRepository;

    @Transactional(readOnly = true)
    public List<IntroductionDTO> getIntroductions() {
        List<Introduction> introductions = presentationRepository.getActiveIntroductions();
        return introductions.stream().map(IntroductionDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<LinkDTO> getLinks() {
        List<Link> links = presentationRepository.getActiveLinks();
        return links.stream().map(LinkDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ResumeDTO getResume() {
        List<Experience> experiences = presentationRepository.getActiveExperiences();
        List<Achievement> achievements = presentationRepository.getActiveAchievements();
        List<Skill> skills = presentationRepository.getActiveSkills();
        return new ResumeDTO(experiences, achievements, skills);
    }

    @Transactional(readOnly = true)
    public List<ProjectDTO> getProjects() {
        List<Project> projects = presentationRepository.getActiveProjects();
        return projects.stream().map(ProjectDTO::new).toList();
    }
}
