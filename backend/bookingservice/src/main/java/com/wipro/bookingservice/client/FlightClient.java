package com.wipro.bookingservice.client;

import com.wipro.bookingservice.model.Flight;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "flight-service", fallback = FlightClientFallback.class)
public interface FlightClient {

    @GetMapping("/flights/search")
    List<Flight> searchFlights(@RequestParam String source, @RequestParam String destination);
}

   