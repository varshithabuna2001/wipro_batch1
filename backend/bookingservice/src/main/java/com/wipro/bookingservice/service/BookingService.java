package com.wipro.bookingservice.service;

import com.wipro.bookingservice.client.FlightClient;
import com.wipro.bookingservice.model.Flight;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private FlightClient flightClient;

    @CircuitBreaker(name = "flightServiceCB", fallbackMethod = "fallbackFlights")
    public List<Flight> getFlights(String source, String destination) {
        return flightClient.searchFlights(source, destination);
    }

    // fallback method
    public List<Flight> fallbackFlights(String source, String destination, Throwable t) {
        System.out.println("⚠️ Circuit Breaker triggered: " + t.getMessage());
        return Collections.emptyList();
    }
}
