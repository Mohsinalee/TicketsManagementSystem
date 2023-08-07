package com.systems.ticketsmanagement.repository;

import com.systems.ticketsmanagement.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
