package it.academy.paymentSystem.repository;

import it.academy.paymentSystem.model.Thing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThingRepository extends JpaRepository<Thing, Long> {
}
