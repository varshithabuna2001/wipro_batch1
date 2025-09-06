package com.wipro.bookingservice.model;

public class Flight {

    private Long id;
    private String source;
    private String destination;
    private double price;

    
    public Flight() {}

    public Flight(Long id, String source, String destination, double price) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
