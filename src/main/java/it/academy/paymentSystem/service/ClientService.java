package it.academy.paymentSystem.service;

import it.academy.paymentSystem.model.Client;
import it.academy.paymentSystem.model.Payment;

import java.math.BigDecimal;
import java.util.List;

public interface ClientService {
    Client addClient(Client c);
    List<Client> getAllClients();
    Client changeActiveStatus(Client c);
    Client getClientById(Long id);
    List<Payment> getClientPayments(Long id);
    List<Payment> getOkPayments(Long id);

    BigDecimal getSumPayments(Long id);
}

