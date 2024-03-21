package com.davin.portfolio.domain.repository;

import com.davin.portfolio.domain.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
