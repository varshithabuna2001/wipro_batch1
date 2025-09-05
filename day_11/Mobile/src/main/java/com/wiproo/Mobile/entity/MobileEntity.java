package com.wiproo.Mobile.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mobiles")
public class MobileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                // integer id

    @Column(name = "make")
    private String make;

    @Column(name = "model_number", unique = true)
    private String modelNumber;

    @Column(name = "price")
    private double price;

    public MobileEntity() {}

    public MobileEntity(Integer id, String make, String modelNumber, double price) {
        this.id = id;
        this.make = make;
        this.modelNumber = modelNumber;
        this.price = price;
    }

    // getters & setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModelNumber() { return modelNumber; }
    public void setModelNumber(String modelNumber) { this.modelNumber = modelNumber; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "MobileEntity [id=" + id + ", make=" + make + ", modelNumber=" + modelNumber + ", price=" + price + "]";
    }
}
