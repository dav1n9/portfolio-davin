package com.davin.portfolio.domain.repository;

import com.davin.portfolio.domain.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    List<Experience> findAllByIsActive(Boolean isActive);
}
