package it.academy.paymentSystem.model;

import it.academy.paymentSystem.enums.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

@Entity
public class Payment {
    public static Random r = new Random();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //private String status;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    private BigDecimal amount;

    private Integer confirmationCode;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private LocalDateTime time;

    public Payment() {
    }

    public Payment(Long id, Status status, BigDecimal amount, Integer confirmationCode, Client client, LocalDateTime time) {
        this.id = id;
        this.status = status;
        this.amount = amount;
        this.confirmationCode = confirmationCode;
        this.client = client;
        this.time = time;
    }

    //    public Payment(Long id, String status, BigDecimal amount, Client client) {
//        this.id = id;
//        this.status = status;
//        this.amount = amount;
//        this.client = client;
//
//        this.time = LocalDateTime.now();
//    }

    public Payment(BigDecimal amount, Client client) {
        this.amount = amount;
        this.client = client;

        this.time = LocalDateTime.now();

        if (amount.remainder(BigDecimal.valueOf(2))
                .equals(BigDecimal.ZERO)){

            this.confirmationCode = r.nextInt(9000) + 1000;
            System.out.println(confirmationCode);
            this.status = Status.AWAITING_CONFIRMATION;
        }
        else {
            this.status = Status.ERROR;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getStatus() {
//        return status;
//    }

//    public void setStatus(String status) {
//        this.status = status;
//    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public Integer getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(Integer confirmationCode) {
        this.confirmationCode = confirmationCode;
    }
}
