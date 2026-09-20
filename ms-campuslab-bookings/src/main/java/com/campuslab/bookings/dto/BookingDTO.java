package com.campuslab.bookings.dto;

import java.time.LocalDateTime;

public class BookingDTO {
    private String id;
    private String userEmail;
    private String resourceId;
    private String resourceName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status; // SOLICITADA, APROBADA, RECHAZADA, CANCELADA

    public BookingDTO() {}

    public BookingDTO(String id, String userEmail, String resourceId, String resourceName, LocalDateTime startDate, LocalDateTime endDate, String status) {
        this.id = id;
        this.userEmail = userEmail;
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getResourceId() { return resourceId; }
    public void setResourceId(String resourceId) { this.resourceId = resourceId; }

    public String getResourceName() { return resourceName; }
    public void setResourceName(String resourceName) { this.resourceName = resourceName; }

    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }

    public LocalDateTime getEndDate() { return endDate; }
    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}