package com.davin.portfolio.domain.repository;

import com.davin.portfolio.domain.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    @Query("select e from Experience e left join fetch e.details where e.isActive = :isActive")
    List<Experience> findAllByIsActive(@Param("isActive") boolean isActive);

    @Override
    @Query("select e from Experience e left join fetch e.details where e.id = :id")
    Optional<Experience> findById(@Param("id") Long id);
}
