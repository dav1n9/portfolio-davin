package com.davin.portfolio.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "project_detail_id")
    private Long id;
    private String content;
    private String url;
    private boolean isActive;

    @Builder
    public ProjectDetail(String content, String url, boolean isActive) {
        this.content = content;
        this.url = url;
        this.isActive = isActive;
    }

    public void update(String content, String url, boolean isActive) {
        this.content = content;
        this.url = url;
        this.isActive = isActive;
    }
}