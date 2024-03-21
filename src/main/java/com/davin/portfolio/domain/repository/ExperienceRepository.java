package com.davin.portfolio.domain.repository;

import com.davin.portfolio.domain.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
