package it.academy.paymentSystem.repository;

import it.academy.paymentSystem.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("select p from Payment p join fetch p.client c " +
            "where c.id = :clientId and c.password = :passCode")
    public List<Payment> getAllPaymentsByPassCode(@Param("clientId") Long clientId, @Param("passCode") String passCode);
}
