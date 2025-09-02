package com.wipro.bookingservice.model;

public class Payment {
    private Long bookingId;
    private double amount;
    private String status;

    
    public Payment() {}

    public Payment(Long bookingId, double amount, String status) {
        this.bookingId = bookingId;
        this.amount = amount;
        this.status = status;
    }

    
    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
