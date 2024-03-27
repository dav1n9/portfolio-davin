package com.davin.portfolio.domain.repository;

import com.davin.portfolio.domain.entity.HttpInterface;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface HttpInterfaceRepository extends JpaRepository<HttpInterface, Long> {
    Long countAllByCreatedDateTimeBetween(LocalDateTime start, LocalDateTime end);
}
