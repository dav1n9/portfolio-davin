package com.davin.portfolio.domain.repository;

import com.davin.portfolio.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
