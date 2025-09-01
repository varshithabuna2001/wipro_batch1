package com.wipro.bookingservice.client;

import com.wipro.bookingservice.model.Flight;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;

@Component
public class FlightClientFallback implements FlightClient {
    @Override
    public List<Flight> searchFlights(String source, String destination) {
        System.out.println("Flight service down, returning fallback response");
        return Collections.emptyList();
    }
}
