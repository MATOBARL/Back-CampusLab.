package com.campuslab.catalog.service;

import com.campuslab.catalog.dto.ResourceDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CatalogService {

    private final List<ResourceDTO> resources = new ArrayList<>();

    public CatalogService() {
        // Datos mock para pruebas de catálogo
        resources.add(new ResourceDTO("LAB-101", "Laboratorio de Redes y Telecomunicaciones", "LABORATORIO", "Capacidad para 30 estudiantes con racks Cisco", true, 1));
        resources.add(new ResourceDTO("EQU-202", "Osciloscopio Digital Tektronix", "EQUIPO", "Ancho de banda 100 MHz, 2 canales", true, 12));
        resources.add(new ResourceDTO("IMP-303", "Impresora 3D Creality Ender 3 Pro", "HERRAMIENTA", "Área de impresión 220x220x250mm", false, 0));
    }

    public List<ResourceDTO> getAllResources() {
        return resources;
    }

    public Optional<ResourceDTO> getResourceById(String id) {
        return resources.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    public ResourceDTO createResource(ResourceDTO resource) {
        resource.setId("RES-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        resources.add(resource);
        return resource;
    }
}