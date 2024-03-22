package com.davin.portfolio.domain.entity;

import com.davin.portfolio.domain.constant.SkillType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Skill extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "skill_id")
    private Long id;

    private String name;
    @Column(name = "skill_type")
    @Enumerated(value = EnumType.STRING)
    private SkillType type;
    private Boolean isActive;

    @Builder
    public Skill(String name, String type, Boolean isActive) {
        this.name = name;
        this.type = SkillType.valueOf(type);
        this.isActive = isActive;
    }
}