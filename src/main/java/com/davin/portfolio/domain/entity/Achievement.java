package com.davin.portfolio.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Achievement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "achievement_id")
    private Long id;

    private String title;
    private String description;
    private LocalDate achievedDate;
    private String host;
    private Boolean isActive;

    @Builder
    public Achievement(String title, String description, LocalDate achievedDate, String host, Boolean isActive) {
        this.title = title;
        this.description = description;
        this.achievedDate = achievedDate;
        this.host = host;
        this.isActive = isActive;
    }
}