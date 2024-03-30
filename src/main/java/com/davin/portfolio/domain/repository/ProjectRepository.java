package com.davin.portfolio.domain.repository;

import com.davin.portfolio.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("select p from Project p left join fetch p.skills s left join fetch s.skill where p.isActive = :isActive")
    List<Project> findAllByIsActive(@Param("isActive") Boolean isActive);

    @Override
    @Query("select p from Project p left join fetch p.details where p.id = :id")
    Optional<Project> findById(@Param("id") Long id);
}
