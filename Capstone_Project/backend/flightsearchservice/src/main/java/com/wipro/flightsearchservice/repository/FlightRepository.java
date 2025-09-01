package com.wipro.flightsearchservice.repository;

import com.wipro.flightsearchservice.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    // Existing method
    List<Flight> findByOriginAndDestination(String origin, String destination);
    
    // New method to resolve the compilation error
    List<Flight> findByOriginAndDestinationAndDepartureTime(String origin, String destination, String departureTime);
}