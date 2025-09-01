package com.wipro.bookingservice.producer;

import com.wipro.bookingservice.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingProducer {

    private static final String TOPIC = "booking-topic";

    @Autowired
    private KafkaTemplate<String, Booking> kafkaTemplate;

    public void sendBookingEvent(Booking booking) {
        System.out.println("Producing booking event → " + booking);
        kafkaTemplate.send(TOPIC, booking);
    }
}
