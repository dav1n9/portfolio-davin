package com.davin.portfolio.presentation.controller;

import com.davin.portfolio.presentation.dto.IntroductionDTO;
import com.davin.portfolio.presentation.dto.LinkDTO;
import com.davin.portfolio.presentation.dto.ProjectDTO;
import com.davin.portfolio.presentation.dto.ResumeDTO;
import com.davin.portfolio.presentation.service.PresentationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PresentationApiController {
    private final PresentationService presentationService;

    @GetMapping("/v1/introductions")
    public List<IntroductionDTO> getIntroductions() {
        return presentationService.getIntroductions();
    }

    @GetMapping("/v1/links")
    public List<LinkDTO> getLinks() {
        return presentationService.getLinks();
    }

    @GetMapping("/v1/resume")
    public ResumeDTO getResume() {
        return presentationService.getResume();
    }

    @GetMapping("/v1/projects")
    public List<ProjectDTO> getProjects() {
        return presentationService.getProjects();
    }
}