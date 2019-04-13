package it.academy.paymentSystem.service;

import it.academy.paymentSystem.model.Client;
import it.academy.paymentSystem.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client addClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client changeActiveStatus(Client c) {
        if (c.isInactive()) {
            c.setInactive(false);
            clientRepository.save(c);
        }
        return c;
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public BigDecimal getSumPayments(Long id) {
        return clientRepository.getSumPayments(id);
    }
}
