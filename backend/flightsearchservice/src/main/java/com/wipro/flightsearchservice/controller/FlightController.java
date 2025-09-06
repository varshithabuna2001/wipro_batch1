package com.wipro.flightsearchservice.controller;

import com.wipro.flightsearchservice.model.Flight;
import com.wipro.flightsearchservice.repository.FlightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/flights")
@Tag(name = "Flight API", description = "Manage flights")
public class FlightController {

    @Autowired
    private FlightRepository repo;

    @Operation(summary = "Search flights by origin, destination and departure time")
    @GetMapping("/search")
    public List<Flight> search(@RequestParam String origin,
                               @RequestParam String destination,
                               @RequestParam String departureTime) {
        
        return repo.findByOriginAndDestinationAndDepartureTime(origin, destination, departureTime);
    }

    @Operation(summary = "Add a flight")
    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        // This method uses the built-in save() method from JpaRepository
        return repo.save(flight);
    }

    @Operation(summary = "Get all flights")
    @GetMapping
    public List<Flight> all() {
        
        return repo.findAll();
    }
}