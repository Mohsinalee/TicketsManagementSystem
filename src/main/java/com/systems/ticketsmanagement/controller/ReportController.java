package com.systems.ticketsmanagement.controller;

import com.systems.ticketsmanagement.entity.Report;
import com.systems.ticketsmanagement.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {
    private final ReportRepository reportRepository;

    @Autowired
    public ReportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @PostMapping("/{reportId}/assignee")
    public ResponseEntity<String> setAssignee(@PathVariable Long reportId, @RequestBody String assignee) {
        Optional<Report> optionalReport = reportRepository.findById(reportId);
        if (optionalReport.isPresent()) {
            Report report = optionalReport.get();
            report.setAssignee(assignee);
            reportRepository.save(report);
            return ResponseEntity.ok("Assignee updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
