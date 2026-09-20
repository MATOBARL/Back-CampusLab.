package com.campuslab.bff.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ReportClient {

    private final RestClient restClient;

    public ReportClient(@Value("${services.reports-url}") String reportsUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(reportsUrl)
                .build();
    }

    public Object getSummaryReport() {
        return restClient.get()
                .uri("/api/reports/summary")
                .retrieve()
                .body(Object.class);
    }
}