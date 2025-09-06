package com.wipro.hibernet.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Pan")
public class Pan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "panholderName", nullable = false, length = 100)
    private String panholderName;

    @Column(name = "panNumber", nullable = false, unique = true, length = 20)
    private String panNumber;

    public Pan() {}

    public Pan(String panholderName, String panNumber) {
        this.panholderName = panholderName;
        this.panNumber = panNumber;
    }

    public Integer getId() { return id; }
    public String getPanholderName() { return panholderName; }
    public void setPanholderName(String panholderName) { this.panholderName = panholderName; }
    public String getPanNumber() { return panNumber; }
    public void setPanNumber(String panNumber) { this.panNumber = panNumber; }

    @Override
    public String toString() {
        return "Pan{id=" + id +
               ", panholderName='" + panholderName + '\'' +
               ", panNumber='" + panNumber + '\'' +
               '}';
    }
}
