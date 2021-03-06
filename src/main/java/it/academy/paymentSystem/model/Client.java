package it.academy.paymentSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String phoneNo;

    private String fio;

    private boolean inactive;

    @JsonIgnore
    private String password;

    public Client(Long id, String phoneNo, String fio, boolean inactive) {
        this.id = id;
        this.phoneNo = phoneNo;
        this.fio = fio;
        this.inactive = inactive;
    }

    public Client(Long id, String phoneNo, String fio, boolean inactive, String password) {
        this.id = id;
        this.phoneNo = phoneNo;
        this.fio = fio;
        this.inactive = inactive;
        this.password = password;
    }

    public Client() { }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

}
