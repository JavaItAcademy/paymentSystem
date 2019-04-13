package it.academy.paymentSystem.repository;

import it.academy.paymentSystem.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "select sum(p.amount) from Payment " +
            "p inner join p.client c where c.id = :client_id")
    BigDecimal getSumPayments(@Param("client_id") Long client_id);


}
