package com.davin.portfolio.presentation.service;

import com.davin.portfolio.domain.entity.Introduction;
import com.davin.portfolio.domain.entity.Link;
import com.davin.portfolio.domain.entity.Project;
import com.davin.portfolio.presentation.dto.IntroductionDTO;
import com.davin.portfolio.presentation.dto.LinkDTO;
import com.davin.portfolio.presentation.dto.ProjectDTO;
import com.davin.portfolio.presentation.repository.PresentationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PresentationServiceTest {
    @InjectMocks
    PresentationService presentationService;
    @Mock
    PresentationRepository presentationRepository;
    private static final int DATA_SIZE = 9;

    @Test
    void getIntroductions() {
        // given
        List<Introduction> introductions = new ArrayList<>();
        for (int i = 1; i <= DATA_SIZE; i++) {
            Introduction introduction = Introduction.builder()
                    .content(String.valueOf(i))
                    .isActive(i % 2 == 0)    // 짝수만 isActive가 true이다.
                    .build();
            introductions.add(introduction);
        }
        List<Introduction> activeIntroductions = introductions.stream().filter(Introduction::getIsActive).toList();

        Mockito.when(presentationRepository.getActiveIntroductions())
                .thenReturn(activeIntroductions);

        // when
        List<IntroductionDTO> introductionDTOS = presentationService.getIntroductions();

        // then
        assertThat(introductionDTOS).hasSize(DATA_SIZE / 2);

        for (IntroductionDTO dto : introductionDTOS) {
            assertThat(Integer.parseInt(dto.getContent())).isEven();
        }
    }

    @Test
    void getLinks() {
        // given
        List<Link> links = new ArrayList<>();
        for (int i = 1; i <= DATA_SIZE; i++) {
            Link link = Link.builder()
                    .name(String.valueOf(i))
                    .content(String.valueOf(i))
                    .isActive(i % 2 != 0)
                    .build();
            links.add(link);
        }
        List<Link> activeLinks = links.stream().filter(Link::getIsActive).toList();
        Mockito.when(presentationRepository.getActiveLinks())
                .thenReturn(activeLinks);

        // when
        List<LinkDTO> linkDTOS = presentationService.getLinks();

        // then
        int expectedSize = DATA_SIZE / 2;
        if ((DATA_SIZE % 2) != 0) expectedSize += 1;
        assertThat(linkDTOS).hasSize(expectedSize);
        for (LinkDTO linkDTO : linkDTOS) {
            assertThat(Integer.parseInt(linkDTO.getContent())).isOdd();
        }

    }

    @Test
    void getProjects() {
        List<Project> projects = new ArrayList<>();
        for (int i = 1; i <= DATA_SIZE; i++) {
            Project project = Project.builder()
                    .name(String.valueOf(i)).description(String.valueOf(i))
                    .startYear(24).startMonth(4)
                    .endYear(24).endMonth(4)
                    .isActive(true)
                    .build();
            projects.add(project);
        }
        List<Project> activeLinks = projects.stream().filter(Project::getIsActive).toList();
        Mockito.when(presentationRepository.getActiveProjects())
                .thenReturn(activeLinks);

        List<ProjectDTO> projectDTOs = presentationService.getProjects();

        assertThat(projectDTOs).hasSize(DATA_SIZE);
    }
}