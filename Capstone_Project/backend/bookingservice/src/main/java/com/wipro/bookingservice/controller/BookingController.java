package com.wipro.bookingservice.controller;

import com.wipro.bookingservice.model.Booking;
import com.wipro.bookingservice.repository.BookingRepository;

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

    @Autowired
    private BookingRepository repo;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Operation(summary = "Create a new booking")
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        booking.setStatus("PENDING");
        Booking saved = repo.save(booking);
        // send booking info to Kafka
        kafkaTemplate.send("booking-topic", saved.getId().toString(),
                saved.getId() + "," + saved.getAmount());
        return saved;
    }

    @Operation(summary = "Get all bookings")
    @GetMapping
    public List<Booking> all() {
        return repo.findAll();
    }
}
