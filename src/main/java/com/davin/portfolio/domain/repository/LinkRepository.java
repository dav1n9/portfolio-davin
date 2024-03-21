package com.davin.portfolio.domain.repository;

import com.davin.portfolio.domain.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
