package it.academy.paymentSystem.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private LocalDateTime time;

    public Payment() {
    }

    public Payment(Long id, String status, BigDecimal amount, Client client) {
        this.id = id;
        this.status = status;
        this.amount = amount;
        this.client = client;

        this.time = LocalDateTime.now();
    }

    public Payment(BigDecimal amount, Client client) {
        this.amount = amount;
        this.client = client;

        this.time = LocalDateTime.now();

        if (amount.remainder(BigDecimal.valueOf(2))
                .equals(BigDecimal.ZERO)){
            this.status = "OK";
        }
        else {
            this.status = "ERROR";
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
