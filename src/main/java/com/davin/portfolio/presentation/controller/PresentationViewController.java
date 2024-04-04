package com.davin.portfolio.presentation.controller;

import com.davin.portfolio.domain.constant.SkillType;
import com.davin.portfolio.presentation.dto.IntroductionDTO;
import com.davin.portfolio.presentation.dto.LinkDTO;
import com.davin.portfolio.presentation.dto.ProjectDTO;
import com.davin.portfolio.presentation.dto.ResumeDTO;
import com.davin.portfolio.presentation.service.PresentationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PresentationViewController {
    private final PresentationService presentationService;

    @GetMapping("/")
    public String index(Model model) {
        List<IntroductionDTO> introductions = presentationService.getIntroductions();
        model.addAttribute("introductions", introductions);

        List<LinkDTO> links = presentationService.getLinks();
        model.addAttribute("links", links);

        return "presentation/index";
    }

    @GetMapping("/resume")
    public String resume(Model model) {
        ResumeDTO resume = presentationService.getResume();
        model.addAttribute("resume", resume);
        model.addAttribute("skillTypes", SkillType.values());

        return "presentation/resume";
    }

    @GetMapping("/projects")
    public String projects(Model model) {
        List<ProjectDTO> projects = presentationService.getProjects();
        model.addAttribute("projects", projects);

        return "presentation/projects";
    }
}
