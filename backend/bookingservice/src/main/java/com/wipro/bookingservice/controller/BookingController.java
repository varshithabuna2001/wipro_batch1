package com.wipro.bookingservice.controller;

import com.wipro.bookingservice.model.Booking;
import com.wipro.bookingservice.model.Flight;  
import com.wipro.bookingservice.repository.BookingRepository;
import com.wipro.bookingservice.service.BookingService; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@Tag(name = "Booking API", description = "Manage bookings")
public class BookingController {

    private static final String TOPIC = "booking-topic";

    @Autowired
    private BookingRepository repo;

    @Autowired
    private KafkaTemplate<String, Booking> kafkaTemplate;

    @Autowired
    private BookingService bookingService;  // ✅ Add this

    @Operation(summary = "Create a new booking")
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        booking.setStatus("PENDING");
        Booking saved = repo.save(booking);

        // Send booking event to Kafka
        kafkaTemplate.send(TOPIC, saved.getId().toString(), saved);
        System.out.println("🚀 Sent booking event to Kafka: " + saved);

        return saved;
    }

    @Operation(summary = "Get all bookings")
    @GetMapping
    public List<Booking> all() {
        return repo.findAll();
    }

    @Operation(summary = "Search available flights")
    @GetMapping("/search-flights")
    public List<Flight> searchFlights(@RequestParam String source, @RequestParam String destination) {
        return bookingService.getFlights(source, destination); // ✅ Uses Circuit Breaker
    }
}
