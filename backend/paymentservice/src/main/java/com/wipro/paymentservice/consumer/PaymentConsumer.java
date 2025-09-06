package com.wipro.paymentservice.consumer;

import com.wipro.paymentservice.model.Payment;
import com.wipro.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    @Autowired
    private PaymentRepository repo;

    @KafkaListener(topics = "booking-topic", groupId = "payment-group")
    public void consume(String message) {
        
        String[] parts = message.split(",");
        Long bookingId = Long.parseLong(parts[0]);
        Double amount = Double.parseDouble(parts[1]);

        Payment payment = new Payment();
        payment.setBookingId(bookingId);
        payment.setAmount(amount);
        payment.setStatus("SUCCESS");

        repo.save(payment);
        System.out.println("Payment processed for Booking ID: " + bookingId);
    }
}
