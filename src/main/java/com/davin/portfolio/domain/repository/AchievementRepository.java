package com.davin.portfolio.domain.repository;

import com.davin.portfolio.domain.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement> findAllByIsActive(Boolean isActive);
}
