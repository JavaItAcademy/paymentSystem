package it.academy.paymentSystem.repository;

import it.academy.paymentSystem.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
