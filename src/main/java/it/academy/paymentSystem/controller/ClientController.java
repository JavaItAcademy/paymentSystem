package it.academy.paymentSystem.controller;

import it.academy.paymentSystem.model.Client;
import it.academy.paymentSystem.model.Payment;
import it.academy.paymentSystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    private List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    private Client getOneClient(@PathVariable Long id){
        return clientService.getClientById(id);
    }


    @GetMapping("/{id}/sum")
    private BigDecimal getSum(@PathVariable Long id){
        return clientService.getSumPayments(id);
    }

    @GetMapping("/{id}/payments")
    private List<Payment> getPayments(@PathVariable Long id){
        return clientService.getClientPayments(id);
    }
    @GetMapping("/{id}/okPayments")
    private List<Payment> getOkPayments(@PathVariable Long id){
        return clientService.getOkPayments(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Client addClient(@RequestBody Client c){
        return clientService.addClient(c);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private Client changeClient(@RequestBody Client c){
        return clientService.changeActiveStatus(c);
    }


}
