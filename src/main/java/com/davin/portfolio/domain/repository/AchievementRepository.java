package com.davin.portfolio.domain.repository;

import com.davin.portfolio.domain.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
}
