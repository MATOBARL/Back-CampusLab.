package com.campuslab.reports.dto;

import java.util.Map;

public class ReportSummaryDTO {
    private int totalBookings;
    private int approvedBookings;
    private int pendingBookings;
    private double occupancyRate; // Porcentaje de ocupación
    private Map<String, Integer> topResources;

    public ReportSummaryDTO() {}

    public ReportSummaryDTO(int totalBookings, int approvedBookings, int pendingBookings, double occupancyRate, Map<String, Integer> topResources) {
        this.totalBookings = totalBookings;
        this.approvedBookings = approvedBookings;
        this.pendingBookings = pendingBookings;
        this.occupancyRate = occupancyRate;
        this.topResources = topResources;
    }

    // Getters y Setters
    public int getTotalBookings() { return totalBookings; }
    public void setTotalBookings(int totalBookings) { this.totalBookings = totalBookings; }

    public int getApprovedBookings() { return approvedBookings; }
    public void setApprovedBookings(int approvedBookings) { this.approvedBookings = approvedBookings; }

    public int getPendingBookings() { return pendingBookings; }
    public void setPendingBookings(int pendingBookings) { this.pendingBookings = pendingBookings; }

    public double getOccupancyRate() { return occupancyRate; }
    public void setOccupancyRate(double occupancyRate) { this.occupancyRate = occupancyRate; }

    public Map<String, Integer> getTopResources() { return topResources; }
    public void setTopResources(Map<String, Integer> topResources) { this.topResources = topResources; }
}