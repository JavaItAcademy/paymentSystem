package it.academy.paymentSystem.repository;

import it.academy.paymentSystem.enums.Status;
import it.academy.paymentSystem.model.Client;
import it.academy.paymentSystem.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "select sum(p.amount) from Payment " +
            "p inner join p.client c where c.id = :client_id " +
            "and p.status <> it.academy.paymentSystem.enums.Status.ERROR")
    BigDecimal getSumPayments(@Param("client_id") Long client_id);

    @Query(value = "select p from Payment " +
            "p inner join p.client c where c.id = :client_id " +
            "and p.status in :status")
    List<Payment> getClientPayments(@Param("client_id") Long client_id,
                                    @Param ("status")List<Status> status);


}
