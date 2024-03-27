package com.davin.portfolio.domain.repository;

import com.davin.portfolio.domain.entity.Introduction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IntroductionRepository extends JpaRepository<Introduction, Long> {
    List<Introduction> findAllByIsActive(Boolean isActive);
}
