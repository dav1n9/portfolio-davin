package com.davin.portfolio.presentation.dto;

import com.davin.portfolio.domain.entity.ProjectDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProjectDetailDTO {
    private String content;
    private String url;

    public ProjectDetailDTO(ProjectDetail projectDetail) {
        content = projectDetail.getContent();
        url = projectDetail.getUrl();
    }
}
