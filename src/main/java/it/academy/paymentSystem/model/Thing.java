package it.academy.paymentSystem.model;

import javax.persistence.*;

@Entity
public class Thing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Thing(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Thing() {
    }

    public Thing(Long id, String value, Client client) {
        this.id = id;
        this.value = value;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

