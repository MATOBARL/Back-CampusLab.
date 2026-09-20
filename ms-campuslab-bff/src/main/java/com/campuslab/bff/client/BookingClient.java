package com.campuslab.bff.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Component
public class BookingClient {

    private final RestClient restClient;

    public BookingClient(@Value("${services.bookings-url}") String bookingsUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(bookingsUrl)
                .build();
    }

    public List<Object> getAllBookings() {
        return restClient.get()
                .uri("/api/bookings")
                .retrieve()
                .body(List.class);
    }

    public Object getBookingById(String id) {
        return restClient.get()
                .uri("/api/bookings/{id}", id)
                .retrieve()
                .body(Object.class);
    }

    public Object createBooking(Map<String, Object> bookingData) {
        return restClient.post()
                .uri("/api/bookings")
                .body(bookingData)
                .retrieve()
                .body(Object.class);
    }

    public Object updateStatus(String id, Map<String, String> statusData) {
        return restClient.put()
                .uri("/api/bookings/{id}/status", id)
                .body(statusData)
                .retrieve()
                .body(Object.class);
    }
}