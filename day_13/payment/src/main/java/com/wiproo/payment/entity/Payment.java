package com.wiproo.payment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    @Column(name = "payment_id", nullable = false, unique = true)
    @NotBlank(message = "paymentId is required")
    private String paymentId; 

    @Column(name = "payment_mode", nullable = false)
    @NotBlank(message = "paymentMode is required")
    private String paymentMode; 

    @Column(nullable = false, precision = 13, scale = 2)
    @NotNull(message = "amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "amount must be positive")
    private BigDecimal amount;

    @Column(length = 1000)
    private String description;

    public Payment() {}

    public Payment(String paymentId, String paymentMode, BigDecimal amount, String description) {
        this.paymentId = paymentId;
        this.paymentMode = paymentMode;
        this.amount = amount;
        this.description = description;
    }

   
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public String getPaymentMode() { return paymentMode; }
    public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
