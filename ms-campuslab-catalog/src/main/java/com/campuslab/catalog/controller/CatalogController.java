package com.campuslab.catalog.controller;

import com.campuslab.catalog.dto.ResourceDTO;
import com.campuslab.catalog.service.CatalogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/resources")
    public ResponseEntity<List<ResourceDTO>> getAllResources() {
        return ResponseEntity.ok(catalogService.getAllResources());
    }

    @GetMapping("/resources/{id}")
    public ResponseEntity<ResourceDTO> getResourceById(@PathVariable String id) {
        return catalogService.getResourceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/resources")
    public ResponseEntity<ResourceDTO> createResource(@RequestBody ResourceDTO resource) {
        ResourceDTO created = catalogService.createResource(resource);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}