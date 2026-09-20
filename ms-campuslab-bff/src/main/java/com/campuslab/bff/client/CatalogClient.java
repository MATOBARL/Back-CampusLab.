package com.campuslab.bff.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class CatalogClient {

    private final RestClient restClient;

    public CatalogClient(@Value("${services.catalog-url}") String catalogUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(catalogUrl)
                .build();
    }

    public List<Object> getAllResources() {
        return restClient.get()
                .uri("/api/catalog/resources")
                .retrieve()
                .body(List.class);
    }

    public Object getResourceById(String id) {
        return restClient.get()
                .uri("/api/catalog/resources/{id}", id)
                .retrieve()
                .body(Object.class);
    }

    public Object createResource(Object resourceData) {
        return restClient.post()
                .uri("/api/catalog/resources")
                .body(resourceData)
                .retrieve()
                .body(Object.class);
    }
}