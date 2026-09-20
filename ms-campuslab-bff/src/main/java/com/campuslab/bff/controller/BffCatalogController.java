package com.campuslab.bff.controller;

import com.campuslab.bff.client.CatalogClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class BffCatalogController {

    private final CatalogClient catalogClient;

    public BffCatalogController(CatalogClient catalogClient) {
        this.catalogClient = catalogClient;
    }

    @GetMapping("/resources")
    public ResponseEntity<List<Object>> getAllResources() {
        return ResponseEntity.ok(catalogClient.getAllResources());
    }

    @GetMapping("/resources/{id}")
    public ResponseEntity<Object> getResourceById(@PathVariable String id) {
        return ResponseEntity.ok(catalogClient.getResourceById(id));
    }

    @PostMapping("/resources")
    public ResponseEntity<Object> createResource(@RequestBody Object resourceData) {
        return ResponseEntity.status(HttpStatus.CREATED).body(catalogClient.createResource(resourceData));
    }
}