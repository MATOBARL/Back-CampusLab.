package com.campuslab.reports.service;

import com.campuslab.reports.dto.ReportSummaryDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ReportService {

    public ReportSummaryDTO getGeneralReport() {
        // Datos mock para el dashboard de administración/auditoría
        return new ReportSummaryDTO(
            128,
            95,
            12,
            78.5,
            Map.of(
                "Laboratorio de Redes", 45,
                "Osciloscopio Digital", 32,
                "Impresora 3D", 28
            )
        );
    }
}