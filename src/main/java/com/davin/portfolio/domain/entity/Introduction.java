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
public class Introduction extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "introduction_id")
    private Long id;

    private String content;
    private String host;
    private Boolean isActive;

    @Builder
    public Introduction(String content, String host, Boolean isActive) {
        this.content = content;
        this.host = host;
        this.isActive = isActive;
    }
}