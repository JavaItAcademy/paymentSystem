package it.academy.paymentSystem.service;

import it.academy.paymentSystem.model.Client;
import it.academy.paymentSystem.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment addPayment(Payment p);
    List<Payment> getAllPayments();
    Payment getPaymentById(Long id);
}
