package com.wipro.bookingservice.client;

import com.wipro.bookingservice.model.Booking;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "FLIGHT-SEARCH-SERVICE")
public interface FlightClient {

    @GetMapping("/flights/search")
    List<Booking> searchFlights(@RequestParam String origin,
                               @RequestParam String destination);

    @GetMapping("/flights")
    List<Booking> getAllFlights();
}
