package com.davin.portfolio.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExperienceDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "experience_detail_id")
    private Long id;
    private String content;
    private boolean isActive;

    @Builder
    public ExperienceDetail(String content, boolean isActive) {
        this.content = content;
        this.isActive = isActive;
    }

    public void update(String content, boolean isActive) {
        this.content = content;
        this.isActive = isActive;
    }
}