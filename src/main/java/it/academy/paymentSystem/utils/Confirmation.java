package it.academy.paymentSystem.utils;

public class Confirmation{
    private Long id;
    private Integer confirmationCode;

    public Confirmation(Long id, Integer confirmationCode) {
        this.id = id;
        this.confirmationCode = confirmationCode;
    }

    public Confirmation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(Integer confirmationCode) {
        this.confirmationCode = confirmationCode;
    }
}
