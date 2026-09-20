package com.campuslab.bff.controller;

import com.campuslab.bff.client.BookingClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BffBookingController {

    private final BookingClient bookingClient;

    public BffBookingController(BookingClient bookingClient) {
        this.bookingClient = bookingClient;
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAllBookings() {
        return ResponseEntity.ok(bookingClient.getAllBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookingById(@PathVariable String id) {
        return ResponseEntity.ok(bookingClient.getBookingById(id));
    }

    @PostMapping
    public ResponseEntity<Object> createBooking(@RequestBody Map<String, Object> bookingData) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingClient.createBooking(bookingData));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Object> updateStatus(@PathVariable String id, @RequestBody Map<String, String> statusData) {
        return ResponseEntity.ok(bookingClient.updateStatus(id, statusData));
    }
}