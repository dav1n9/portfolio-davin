package com.davin.portfolio.presentation.dto;

import com.davin.portfolio.domain.entity.Link;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LinkDTO {
    private String name;
    private String content;

    public LinkDTO(Link link) {
        name = link.getName().toLowerCase();
        content = link.getContent();
    }
}
