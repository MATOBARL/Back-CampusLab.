package com.campuslab.bff.controller;

import com.campuslab.bff.client.ReportClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class BffReportController {

    private final ReportClient reportClient;

    public BffReportController(ReportClient reportClient) {
        this.reportClient = reportClient;
    }

    @GetMapping("/summary")
    public ResponseEntity<Object> getSummary() {
        return ResponseEntity.ok(reportClient.getSummaryReport());
    }
}