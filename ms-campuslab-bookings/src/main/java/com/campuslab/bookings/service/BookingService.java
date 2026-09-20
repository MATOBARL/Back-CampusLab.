package com.campuslab.bookings.service;

import com.campuslab.bookings.dto.BookingDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class BookingService {

    private final List<BookingDTO> bookings = new ArrayList<>();

    public BookingService() {
        // Datos mock de prueba iniciales
        bookings.add(new BookingDTO("1", "estudiante@duocuc.cl", "LAB-101", "Laboratorio de Redes", LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(2), "SOLICITADA"));
        bookings.add(new BookingDTO("2", "estudiante2@duocuc.cl", "EQU-202", "Osciloscopio Digital", LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(2).plusHours(1), "APROBADA"));
    }

    public List<BookingDTO> getAllBookings() {
        return bookings;
    }

    public Optional<BookingDTO> getBookingById(String id) {
        return bookings.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    public BookingDTO createBooking(BookingDTO booking) {
        booking.setId(UUID.randomUUID().toString());
        if (booking.getStatus() == null) {
            booking.setStatus("SOLICITADA");
        }
        bookings.add(booking);
        return booking;
    }

    public Optional<BookingDTO> updateStatus(String id, String newStatus) {
        Optional<BookingDTO> bookingOpt = getBookingById(id);
        bookingOpt.ifPresent(b -> b.setStatus(newStatus));
        return bookingOpt;
    }
}