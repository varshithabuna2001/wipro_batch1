package com.wipro.paymentservice.consumer;

import com.wipro.paymentservice.model.Payment;
import com.wipro.paymentservice.repository.PaymentRepository;
import com.wipro.paymentservice.service.PaymentService;
import com.wipro.paymentservice.dto.BookingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    @Autowired
    private PaymentRepository paymentRepository;

    @KafkaListener(topics = "booking-topic", groupId = "payment-group")
    public void consumeBookingEvent(BookingEvent bookingEvent) {
        System.out.println("📥 Consumed booking event: " + bookingEvent);

        // Convert BookingEvent → Payment
        Payment payment = new Payment();
        payment.setBookingId(bookingEvent.getId());
        payment.setAmount(bookingEvent.getAmount());
        payment.setStatus("SUCCESS");

        paymentRepository.save(payment);

        System.out.println("💰 Payment processed and saved: " + payment);
    }
}
