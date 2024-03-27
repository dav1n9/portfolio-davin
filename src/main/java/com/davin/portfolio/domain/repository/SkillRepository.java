package com.davin.portfolio.domain.repository;

import com.davin.portfolio.domain.constant.SkillType;
import com.davin.portfolio.domain.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findAllByIsActive(Boolean isActive);

    Optional<Skill> findByNameIgnoreCaseAndType(String name, SkillType type);
}