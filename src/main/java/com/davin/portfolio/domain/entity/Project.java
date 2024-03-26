package com.davin.portfolio.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "project_id")
    private Long id;
    private String name;
    private String description;
    private Integer startYear;
    private Integer startMonth;
    private Integer endYear;
    private Integer endMonth;
    private boolean isActive;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private final List<ProjectDetail> details = new ArrayList<>();
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public final List<ProjectSkill> skills = new ArrayList<>();

    @Builder
    public Project(String name, String description, Integer startYear, Integer startMonth,
                   Integer endYear, Integer endMonth, boolean isActive) {
        this.name = name;
        this.description = description;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.endYear = endYear;
        this.endMonth = endMonth;
        this.isActive = isActive;
    }

    public String getEndYearMonth() {
        if (endYear == null || endMonth == null) return "Present";
        return endYear + "." + endMonth;
    }

    public void update(String name, String description, Integer startYear, Integer startMonth,
                       Integer endYear, Integer endMonth, boolean isActive) {
        this.name = name;
        this.description = description;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.endYear = endYear;
        this.endMonth = endMonth;
        this.isActive = isActive;
    }

    public void addDatails(List<ProjectDetail> details) {
        if (details != null) {
            this.details.addAll(details);
        }
    }
}