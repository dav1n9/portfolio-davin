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
public class Experience extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "experience_id")
    private Long id;
    private String title;
    private String description;
    private Integer startYear;
    private Integer startMonth;
    private Integer endYear;
    private Integer endMonth;
    private Boolean isActive;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_id")
    private final List<ExperienceDetail> details = new ArrayList<>();

    @Builder
    public Experience(String title, String description, Integer startYear, Integer startMonth,
                      Integer endYear, Integer endMonth, boolean isActive) {
        this.title = title;
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

    public void update(String title, String description, Integer startYear, Integer startMonth,
                       Integer endYear, Integer endMonth, boolean isActive) {
        this.title = title;
        this.description = description;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.endYear = endYear;
        this.endMonth = endMonth;
        this.isActive = isActive;
    }

    public void addDetails(List<ExperienceDetail> details) {
        if (details != null) {
            this.details.addAll(details);
        }
    }
}