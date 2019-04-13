package it.academy.paymentSystem.bootstrap;

import it.academy.paymentSystem.model.Client;
import it.academy.paymentSystem.model.Payment;
import it.academy.paymentSystem.service.ClientService;
import it.academy.paymentSystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private ClientService clientService;

    @Autowired
    private PaymentService paymentService;

    @Override
    public void run(String... args) throws Exception {
        Client c1 = new Client();
        c1.setFio("Pikachu");
        c1.setInactive(false);
        c1.setPhoneNo("0312");

        clientService.addClient(c1);

        Payment payment = new Payment(BigDecimal.TEN, c1);
        paymentService.addPayment(payment);
        Payment payment2 = new Payment(BigDecimal.ONE, c1);
        paymentService.addPayment(payment2);
    }
}
